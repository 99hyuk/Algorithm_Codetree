-- 코드를 입력하세요

select FLAVOR
from (
SELECT * from FIRST_HALF f
union all
SELECT * from JULY j) as t
group by FLAVOR
order by sum(TOTAL_ORDER) DESC
limit 3;