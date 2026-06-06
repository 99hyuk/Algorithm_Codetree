-- 코드를 입력하세요
SELECT USER_ID,	NICKNAME, concat(city, ' ' , street_address1, ' ' ,street_address2) as 전체주소, concat(left(TLNO, 3),'-',substr(TLNO, 4, 4),'-',right(TLNO, 4)) as 전화번호
from USED_GOODS_USER u join USED_GOODS_BOARD b on u.user_id = b.writer_id
group by user_id
having count(*) >= 3
order by user_id desc