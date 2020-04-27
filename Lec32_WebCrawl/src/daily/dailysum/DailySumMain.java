package daily.dailysum;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/46476a646a74726f38336a6b78774b/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/46476a646a74726f38336a6b78774b/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/46476a646a74726f38336a6b78774b/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/46476a646a74726f38336a6b78774b/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/46476a646a74726f38336a6b78774b/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/46476a646a74726f38336a6b78774b/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/46476a646a74726f38336a6b78774b/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/46476a646a74726f38336a6b78774b/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ---------------------------------	-------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요


// 46476a646a74726f38336a6b78774b

public class DailySumMain {

	public static final String API_URL_F = "http://openapi.seoul.go.kr:8088/46476a646a74726f38336a6b78774b/%s/SPOP_DAILYSUM_JACHI/%d/%d/%d"; 
	
	public static void main(String[] args) throws IOException {
		System.out.println("연습 : 자치구단위 서울 생활인구 일별 집계표");

		Scanner sc = new Scanner(System.in);
		System.out.print("날짜 입력 : ");
		int date = sc.nextInt();
		sc.nextLine();
		System.out.print("시작Index : ");
		int start = sc.nextInt();
		sc.nextLine();
		System.out.print("끝Index : ");
		int end = sc.nextInt();
		sc.nextLine();
		sc.close();
		
		Document document = Jsoup.connect(getUrl("xml", date, start, end).toString()).parser(Parser.xmlParser()).get();
		Elements elements = document.select("row");
		
		System.out.println("\n[XML]\n날짜\t\t구ID\t총생활인구수\t일최대이동인구수\n--------------------------------------------------------");
		for (Element e : elements) {
			System.out.println(e.selectFirst("STDR_DE_ID").text().trim() + "\t" +
					e.selectFirst("SIGNGU_CODE_SE").text().trim() + "\t" +
					e.selectFirst("TOT_LVPOP_CO").text().trim() + "\t" +
					e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim()
					);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		People list = mapper.readValue(getUrl("json", date, start, end), People.class);

		System.out.println("\n[json]\n날짜\t\t구ID\t총생활인구수\t일최대이동인구수\n--------------------------------------------------------");
		
		for (Info e : list.getDaily().getRow()) {
			System.out.printf("%s\t%s\t%s\t%s\n", e.getDate(), e.getId(), e.getLvPeople(), e.getMvpeople());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main
	
	public static URL getUrl(String type, int date, int start, int end) throws IOException{
		return new URL(String.format(API_URL_F, type, start, end, date));
	}
} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class People {
	@JsonProperty("SPOP_DAILYSUM_JACHI")
	private Daily daily;
	
	public People() {}
	public Daily getDaily() { return daily; }
	public void setDaily(Daily daily) { this.daily = daily; }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Daily {
	private ArrayList<Info> row;
	
	public Daily() {}
	public ArrayList<Info> getRow() { return row; }
	public void setRow(ArrayList<Info> row) { this.row = row; }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Info {
	@JsonProperty("STDR_DE_ID")
	private String date;
	@JsonProperty("SIGNGU_CODE_SE")
	private String id;
	@JsonProperty("TOT_LVPOP_CO")
	private String lvPeople;
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String mvpeople;
	
	public Info() {}
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getLvPeople() { return lvPeople; }
	public void setLvPeople(String lvPeople) { this.lvPeople = lvPeople; }
	public String getMvpeople() { return mvpeople; }
	public void setMvpeople(String mvpeople) { this.mvpeople = mvpeople; }
}