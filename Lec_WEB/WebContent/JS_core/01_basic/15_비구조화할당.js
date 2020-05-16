const ironman = {
    name: "토니스타크"
    ,actor: "로다쥬"
    ,alias: "아이언맨"
};

const captain = {
    name: "스티브 로져스"
    ,actor: "크리스 에반스"
    ,alias: "캡틴 그분"
};

console.log(ironman);
console.log(captain);

// 객체를 매개변수로 받기
function print(hero) {
    let text = `${hero.alias}(${hero.name}) 배우: ${hero.actor}`;
    console.log(text);
}

print(ironman);
print(captain);

// ES6 에 있는
// '비구조화할당 (destructuring assigment)문법'을 사용하면
// 객체변수.속성  <-- 좀더 편리하게 다룰수 있다.
// '비구조화할당 문법'
//   다른말로 '객체 구조 분해'

// 공식
// https://www.ecma-international.org/ecma-262/6.0/#sec-destructuring-assignment
// https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment
// 추가 참조
// https://velog.io/@public_danuel/destructuring-assignment

// 비구조화 할당, 잘 사용하면 코드 깔끔해진다

function print(hero){
    //! 객체 구조 분해
    //! 어떤 (key) 값을 추출할지 명시
    const {alias, name, actor} = hero;

    let text = `${alias}(${name}) 배우: ${actor}`;
    console.log(text);
}

console.log("----------------------------------");
print(ironman);
print(captain);

console.log("----------------------------------");
//! 함수 parameter 에도 비구조화 할당 가능!
//! 받아옴과 동시에 key 매칭!!!
function print2({alias, name, actor}){
    let text = `${alias}(${name}) 배우: ${actor}`;
    console.log(text);
}
print2(ironman);
print2(captain);

//? 꼭 함수 안에서만 써야 하는건 아니다.
//! 변수로 특정 값만 쓰고 싶을 때 쓸 수 있다.
const {name} = ironman;
console.log(name + " " + typeof name);