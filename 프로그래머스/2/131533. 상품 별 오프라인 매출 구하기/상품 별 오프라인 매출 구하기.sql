-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(PRICE * SALES_AMOUNT) as SALES
from PRODUCT p join OFFLINE_SALE o on p.product_id = o.product_id
group by PRODUCT_CODE
order by SALES DESC, PRODUCT_CODE;