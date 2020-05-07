//! 자료형 : data type

//  https://developer.mozilla.org/ko/docs/Web/JavaSCript/Data_structures

//! 동적타이핑 (dynamic type)
//  변수는 고정타입이 없다

//  runtime 에 개발자가 모르는 어떤 타입의 값이 들어올수 있으니 주의!

//  데이터 타입
//  1.기본타입 (primitive)
//   -- boolean
//   -- null
//   -- undefined
//   -- number
//   -- string
//   -- symbol (ES6 에 추가)
//
//  2. 객체 (object)
//   ..

//! boolean
//! true / false
{
    const isTrue = true;
    const isFalse = false;

    console.log(`isTrue = ${isTrue}`, typeof isTrue);
    console.log(`isFalse = ${isFalse}`, typeof isFalse);

    if(isTrue){
        console.log(isTrue, '참 입니다.');
    } else {
        console.log(isTrue, '거짓입니다.');
    }

    // 객체로 생성 가능!은 하지만 비추...
    const a = new Boolean(false);   // false 값을 갖는 Boolean 객체
    console.log('a = ', a, typeof a);

    if(a){  //! new 를 사용하여 생성하면 조건식에서 true 로 동작한다.
        console.log(a, '참 입니다.');
    } else {
        console.log(a, '거짓 입니다.');
    }
    
    //! new 를 사용하지 않고 boolean 만들기
    const b = Boolean(false);   // Boolean() 함수
    console.log('b = ', b, typeof b);

    if(b){  //! new 를 사용하여 생성하면 조건식에서 true 로 동작한다.
        console.log(b, '참 입니다.');
    } else {
        console.log(b, '거짓 입니다.');
    }
}

//! null
//! 값이 없는 object
console.log('\n<null>\n');
{
    const a = null;
    console.log('a = ', a, typeof a);   // null 의 타입은 objec
}

//! undefined
//! 아무 값도 대입 안된 상태
{
    let b;  // 아무 값도 대입 안된 상태, undefined
    console.log('b = ', b, typeof b);

    let a = 10;
    console.log('a = ', a, typeof a);
    a = undefined;  // 다시 undefined 로 대입 가능
    console.log('a = ', a, typeof a);

    a = null; b = undefined;
    if(a == b){     // == : 값이 같은지만 비교
        console.log('== 같습니다.');
    } else {
        console.log('== 다릅니다.');
    }
    
    if(a === b){    // === : 값 뿐 아니라 type 까지 비교
        console.log('=== 같습니다.');
    } else {
        console.log('=== 다릅니다.');
    }
    //  가급적 JS 프로그래밍에서 작성시 
    //? == 보단 === 추천, != 보단 !== 추천
        
}

//! number
console.log('\n<number>');
{
    //? 실수든 점수든 모두 number 타입
    const a = 37;
    console.log('a = ', a, typeof a);
    const b = 3.14;
    console.log('b = ', b, typeof b);

    //! Not a Number
    const c = NaN;  //* Not a Number
    console.log('c = ', c, typeof c);

    let d = Number(123);
    console.log('d = ', d, typeof d);   // number

    d = Number("123");  //* number 로 형변환 됨
    console.log('d = ', d, typeof d);   // number
    
    d = Number("Mark");  //* number 로 형변환 할 수 없지만 object 타입은 number 일 때
    console.log('d = ', d, typeof d);   // NaN
    
    d = parseInt('123');    // Java 방식으로 number 형변환
    console.log('d = ', d, typeof d);
    
    d = parseInt('Alice');    // parseInt로 형변환 실패해도 NaN //*number로 형변환 실패 메세지
    console.log('d = ', d, typeof d);
    
    d = parseFloat('3.14');
    d *= 2;
    console.log('d = ', d, typeof d);
    
    d = parseInt('3.14');   // 3.14 가 3 으로 형변환
    d *= 2;
    console.log('d = ', d, typeof d);
    
    d = parseFloat('300');
    console.log('d = ', d, typeof d);

    num1 = 100; num2 = '100';
    if(num1 == num2){
        console.log(`${num1} == ${num2} 같다`);
    } else {
        console.log(`${num1} == ${num2} 다르다`);
    }
    if(num1 === num2){
        console.log(`${num1} === ${num2} 같다`);
    } else {
        console.log(`${num1} === ${num2} 다르다`);
    }
}

//! string (문자열)
// ' ~ ' , " ~ "
console.log('\n<string>');
{
    let a = 'Mark'
    console.log('a = ', a, typeof a);
    
    a = "Mark"
    console.log('a = ', a, typeof a);
    
    // She's gone
    a = "She's gone";
    console.log('a = ', a, typeof a);
    
    // He says "Hello"
    a = 'He says "Hello"';
    console.log('a = ', a, typeof a);
    
    // He says "I'm fine"
    a = "He says \"I'm fine\"";
    console.log('a = ', a, typeof a);
    
    // + 문자열 연산
    a = "Mark";
    let b = a + " Hamill";
    console.log('b = ', b, typeof b);

    console.log(a * 2); // NaN

    // 문자열 비교연산 가능!    //* 코드순 비교
    console.log("a" > "b");
    console.log("a" < "b");
    console.log("abc" < "abd");
    console.log("AAaa" > "AaAa");   //* false : 대문자 < 소문자

    if("a" > "b") {
        console.log('참 입니다.');
    } else {
        console.log('거짓 입니다.');
    }
}

//-------------------------------------------------
//! symbol
//  ES6 부터 출현
//  https://developer.mozilla.org/ko/docs/Glossary/Symbol
//! '고유'한 값을 만들어낼때 사용
console.log('\n<symbol>');
{
    const a = Symbol(); // new 사용하면 안됨. Symbol is not a constructor
    const b = Symbol(37);
    const c = Symbol("mark");
    const d = Symbol('mark');   // c, d 는 같은 것이 아니다!
                                // '고유'한 Symbol 객체로 만들어진다.
    console.log('a = ', a, typeof a);
    console.log('b = ', b, typeof b);
    console.log('c = ', c, typeof c);
    console.log('d = ', d, typeof d);

    console.log(c == d);
    console.log(c === d);

    // 일반 문자열
    let e = 'Mark', f = 'Mark';
    console.log(e == f);
    console.log(e === f);
}

