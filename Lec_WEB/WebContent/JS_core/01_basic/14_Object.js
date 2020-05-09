// object
console.log('object');

// property:value 쌍
x = {firstName: "John", lastName: "Doe"};
console.log(x, typeof x);

// value 접근하는 방법
console.log(x['firstName'], x.firstName, typeof x.firstName);
// console.log(x[firstName]);   // firstName is not defined.

// object 는 length 값이 없다.
console.log(x.length);

// for ~ in
for(key in x){  // property 가 추출됨.
    console.log(`x[${key}] = ${x[key]}`);
}

// value 는 어떠한 타입이라도 가능!
x = {
    name : "kim"
    ,age : 34
    ,height : 172.3
    ,score : [94, 96, 98]
    ,sayHello : function() {
        console.log("안냥~?")
    }
    ,getScore : function(n) {
        return this.score[n];   // this 빼면 에러!  동일 object 의 property 접근할 때 this 사용!
    }
    ,getTotal : function() {
        var sum = 0;
        var score = this.score;
        for(i = 0; i < score.length; i++){
            sum += score[i];
        }
        return sum;
    }
    ,getAvg : function() {
        var avg = this.getTotal() / this.score.length;
        return avg.toFixed(2);  // 소숫점 2자리까지.
    }
};

console.log(x['name'], typeof x['name']);
console.log(x['age'], typeof x['age']);
console.log(x.height, typeof x.height);
console.log(x.score, x.score.length);
x.sayHello;
console.log(x.getScore(0));
console.log(x.getTotal());  // score 점수 합계
console.log(x.getAvg());    // score 점수 평균
console.log(x['getAvg']());

console.log();

// p:v 추가 / 삭제 / 변경
x = {firstName: "John", lastName: "Doe"};
console.log(x);
x.firstName = "Mike"    //! 변경
console.log(x);

x['age'] = 45;          //! 없던 property 추가
console.log(x);

delete x.firstName;     //! 삭제
console.log(x);

// 없는 property 접근하려 하면
console.log(x.firstName);

// -----------------------------------------
console.log();
var b;
console.log(b);
b = "김재현";
console.log(b);
delete b;               //! 변수 삭제
console.log(b);
console.log();


// '함수'가 'object 생성자'로 사용 가능.
function Person(firstName, lastName, age){
    // 함수 안에서 this!
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    // console.log(this);
}

Person('aaa', 'bbb', 30);   // 호출
var p1 = new Person('aaa', 'bbb', 30);  // 생성자
console.log(p1);
var p2 = new Person('김', '재현', 25);
console.log(p2);

console.log("\n프로그램종료");