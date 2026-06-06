-- 코드를 작성해주세요
select count(*) as FISH_COUNT, max(length) as MAX_LENGTH,	FISH_TYPE
from (select FISH_TYPE, case when o.length <= 10 or o.length is null then 10 else o.length end as LENGTH from FISH_INFO o) t
group by FISH_TYPE
having avg(length) >= 33
order by FISH_TYPE