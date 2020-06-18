$(function(){
	getList();

	$("#mycate select").on("change", function(){
		var parent = $(this).val();
		var depth = $(this).children(":selected").attr("value2");
		depth = parseInt(depth) + 1;
		if(parent != 0){
			getList(depth, parent);
		} else {
			init(depth - 1);
		}
	});
});

function getList(depth, parent){
	$.ajax({
		url: "cate_list.ajax"
		,type: "POST"
		,data: {
			"parent" : parent
			,"depth" : depth
		}
		,success: function(data, status){
			if(status == "success"){
				if(data.status == "OK"){
					if(data.count > 0){
						// 불러올 데이터가 존재한다면
						var items = data.data;
						setList(items[0].depth, items);
					}
				}
			} // end if(status==success)
		}
	});
}

function setList(depth, items){
	var html = "<option value='0' value2='" + items[0].depth + "' selected>==선택하세요==</option>";
	for(var i = 0; i < items.length; i++){
		html += "<option value='" + items[i].uid + "' value2='" + items[i].depth + "'>" + items[i].name + "</option>";
	} // end for
	$("#mycate span:nth-child(" + depth + ") select").html(html);
	$("#mycate span:nth-child(" + depth + ") select").attr("disabled", false);

	if(depth > 0){
		init(depth);
	}
}

function init(depth){
	for(var i = depth; i < $("#mycate>span").length; i++){
		$("#mycate span:nth-child(" + (i + 1) + ") select").html("");
		$("#mycate span:nth-child(" + (i + 1)+ ") select").attr("disabled", true);
	}
}