-- 코드를 입력하세요
SELECT USER_ID,	NICKNAME, sum(price) as TOTAL_SALES
from USED_GOODS_BOARD b join USED_GOODS_USER u on b.writer_id = u.user_id
where status = 'done'
group by user_id
having sum(price) >= 700000
order by TOTAL_SALES;