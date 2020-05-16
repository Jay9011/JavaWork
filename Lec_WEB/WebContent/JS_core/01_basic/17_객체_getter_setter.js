/* object 의 getter, setter

!   getter 함수: 특정 값을 조회할때마다.
!   setter 함수: 특정 값을 설정할때마다.

https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/get

ES 5.1 에 최초 정의
https://www.ecma-international.org/ecma-262/5.1/#sec-11.1.5

ES 6 에서 계산된 프로퍼티 이름이 추가
https://www.ecma-international.org/ecma-262/6.0/#sec-method-definitions


JS 에서 매우 유용
*/

const numbers = {
    a: 1
    ,b: 2

    //! getter 함수
    ,get sum() {
        // get 키워드로 시작
        console.log("sum 함수가 실행됩니다.");
        //! get 은 반.드.시 무엇인가를 리턴해줘야 한다.
        return this.a + this.b;
        //? return 이 빠지면 undefined 를 리턴한다.
    }
}

// getter 함수는아래와 같이 '조회'하려 할 때
// 함수가 호출, 실행 됩니다.
// console.log(numbers.sum()); // numbers.sum is not a function
console.log(numbers.sum);
console.log(numbers.a);
numbers.b = 5;
console.log(numbers.sum);

const dog = {
    _name : "멍멍이"
    
    //! setter 함수
    ,set name(value){
        // set 키워드로 시작
        //! set 은 반.드.시 parameter 설정되어야 한다!
        console.log("이름이 바뀝니다.." + value);
        this._name = value;
    }
}
console.log();
console.log(dog._name);
// dog.name("뽀삐");   // dog.name is not a function
dog.name = "뽀삐";      // setter name() 호출
console.log(dog._name);

const numbers2 = {
    _a : 1
    ,_b : 2
    ,sum : function(){
        return this._a + this._b;
    }
}

console.log(numbers2.sum());
numbers2._a = 10;
numbers2._b = 20;
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());

const numbers3 = {
    _a : 1
    ,_b : 2
    ,sum : 3

    ,get a() {return this._a}
    ,get b() {return this._b}
    ,set a(value) {
        this._a = value;
        this.sum = this._a + this._b;
    }
    ,set b(value) {
        this._b = value;
        this.sum = this._a + this._b;
    }
}

console.log();
console.log(numbers3.sum);
numbers3.a = 10;
numbers3.b = 20;
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);