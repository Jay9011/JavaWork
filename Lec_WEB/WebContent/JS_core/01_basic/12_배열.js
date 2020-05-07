// 배열 생성 방법

//! 방법1 : [ ] 사용
var points = [40, 100, 1, 5, 25, 10];
var fruits = ['Banana', 'Orange', 'Apple', 'Mango'];

console.log('points =', points, typeof points);
console.log('fruits =', fruits.toString()); //* toString 의 경우 예쁘게 나온다
console.log();

// 방법2 : new 사용
var cars = new Array("Saab", "Volvo", "BMW");   // 비추
console.log('cars =', cars, typeof cars);

//! JS 에선 object 의 property 접근 회수를 줄이는 게 성능에 유리.
console.log();
for(i = 0; i < cars.length; i++){
    console.log(cars[i]);
}

console.log();
var length = cars.length;
for(i = 0; i < length; i++){    //? 위의 경우보다 좋은 성능
    console.log(cars[i]);
}

//! for ~ in : 객체(object) 에 대해 사용, property 
for(x in cars){  // value 가 아닌 index 가 나옴.
    console.log('x = ', x);
}

console.log();
//! for ~ of  : ES6부터 사용,  iterable 한 객체에 대해 사용
for(x of cars){
    console.log('x =', x);
}

console.log();
//! 배열.forEach(함수)
//! 배열 원소 하나하나 뽑아내면서 함수 호출
var myFunction = function(value){
    console.log(value);
}
cars.forEach(myFunction);

//! 배열원소 추가
console.log();
fruits[fruits.length] = 'Melon'
console.log(fruits);

//! push 를 더 많이 쓴다.
fruits.push('Lemon');
console.log(fruits);

console.log();
//* 주어진 변수가 배열인지 아닌지 판단
//* typeof 만으로는 object 이기 때문에 알수 없다.

//! 1. isArray() : ES5.1 부터 사용.
console.log(Array.isArray(fruits));

//! 2. 구 브라우저에서 판단하려면 함수만들어서 운영
function isArray(x) {
    return x.constructor.toString().indexOf("Array") > -1;
}
console.log(isArray(fruits));

//! 3. instanceof 연산자
console.log(fruits instanceof Array);

//------------------------------------------------------------
//! join()
// 배열의 원소들을 주어진 문자열로 묶어서 하나의 문자열로 리턴
console.log(cars.join("**"));
console.log([2020, 5, 7].join("/"));
console.log();

//! push() : 배열끝 원소 추가
//! pop() : 배열 끝 원소 추출
//! shift() : 배열 첫 원소 추출
//! unshift() : 배열앞에 원소 추가, 새로운 length 리턴
console.log(fruits.toString());
console.log(fruits.pop());
console.log(fruits.toString());
console.log(fruits.shift());
console.log(fruits.toString());
console.log(fruits.unshift('Grape'));
console.log(fruits.toString());
console.log();

//! splicing
//  첫번째 매개변수 : 삽입될 데이터 위치
//  두번째 매개변수 : 삭제될 데이터 개수
//  세번째 이후 .. : 삽입될 데이터 들..
fruits.splice(2, 0, "Kiwi", "Jadu");
console.log(fruits.toString());

fruits.splice(1, 3, "Durian");
console.log(fruits.toString());

//! concat()
console.log(fruits.concat(["Lemon", "Banana"]));
console.log(fruits.toString());
fruits = fruits.concat(['Lemon', "Banana"])  //* 원본 변화
console.log(fruits.toString())