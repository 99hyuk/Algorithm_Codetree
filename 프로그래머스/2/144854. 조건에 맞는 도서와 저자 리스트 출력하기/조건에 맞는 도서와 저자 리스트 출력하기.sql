-- 코드를 입력하세요
SELECT BOOK_ID,	AUTHOR_NAME,	PUBLISHED_DATE
from BOOK b join AUTHOR a on b.author_id = a.author_id
where category = '경제'
order by PUBLISHED_DATE