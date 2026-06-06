-- 코드를 입력하세요
SELECT hour(datetime), count(*) as count
from ANIMAL_OUTS
where hour(DATETIME) >= 9 && hour(DATETIME) < 20
group by hour(datetime)
order by hour(datetime);