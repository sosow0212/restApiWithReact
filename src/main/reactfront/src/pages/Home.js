import React, { useEffect, useState } from 'react';
import BookItem from '../components/BookItem';

const Home = () => {
  const [books, setBooks] = useState([]);

  // 함수 실행시 최초 한번 실행됨 + 상태값이 변경될때마다 실행
  useEffect(() => {
    fetch('http://localhost:8080/book', {
      method: 'GET', // 생략 가능
    })
      .then((res) => res.json())
      .then((res) => {
        setBooks(res);
      }); // 비동기 함수
  }, []); // 빈 배열은 한번만 실행

  return (
    <div>
      {books.map((book) => (
        <BookItem key={book.id} book={book} />
      ))}
    </div>
  );
};

export default Home;
