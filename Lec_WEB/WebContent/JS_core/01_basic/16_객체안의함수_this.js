const dog = {
    name : "멍멍이"
    ,sound : "멍멍!"

    // 객체 안의 함수 정의하는 다양한 방법들
    // 
    //! 방법1 : 함수 이름을 붙여줌
    ,say1 : function aaa(){
        console.log(this.sound);
        // this 는 함수가 위치(소유)한 객체
    }
    //! 방법2 : 이름 없는 함수를 사용.
    ,say2 : function() {
        console.log(this.sound);
    }
    //! 방법3 : 최신 JS 방식(추천)    !!!브라우저는 아직 지원 안하는 경우가 많으니 지양할것!!!
    //? object 안에서는 key : value 쌍으로 정의해야 하는데, 그냥 쓴다???
    ,say3(){
        console.log(this.sound);
    }
    // 화살표 함수의 경우... this 가 문제 된다.
    ,say4 : () => {
        console.log(this.sound);    //*** undefined ***//
        console.log(this);          //*** {} (비어있는 object) ***//
    }
    // 이유
    // function 키워드로 만든 함수에서의 this는
    // 자기가 속해있는, 객체를 가리키는데..
    // 화살표 함수의 경우
    // this를 자기가 속해 있는 곳으로
    // 연결하지 않습니다.
    // 화살표 함수는 this 가 뭔지 모릅니다!

};

dog.say1();
// dog.aaa();
dog.say2();
dog.say3();
dog.say4();

const cat = {
    name : "야옹이"
    ,sound : "냐아~~~"
}

//cat.say1(); // cat.say1 is not a function
cat.say1 = dog.say1;

dog.say1();
cat.say1(); // 이때 this 는 cat 이 된다. (cat 이 소유하고 있기 때문)
//! this 에 대해 생각해 볼 것!

const sayCat = cat.say1;
console.log(typeof sayCat); // function
sayCat();   // this 에 아무것도 '연결' 되지 않는다! this 는 unefined!