-- 코드를 입력하세요
SELECT FOOD_TYPE,	REST_ID,	REST_NAME,	FAVORITES
from (select *, ROW_NUMBER() over (partition by FOOD_TYPE order by FAVORITES desc) as rk from REST_INFO) t
where rk = 1
group by FOOD_TYPE
order by FOOD_TYPE DESC;