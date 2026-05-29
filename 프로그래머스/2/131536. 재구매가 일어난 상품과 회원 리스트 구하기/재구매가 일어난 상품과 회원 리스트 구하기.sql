-- 코드를 입력하세요
SELECT USER_ID,	PRODUCT_ID
from (select USER_ID, PRODUCT_ID from ONLINE_SALE group by USER_ID, PRODUCT_ID having count(PRODUCT_ID) >= 2) as f
order by user_id ASC, product_id DESC;