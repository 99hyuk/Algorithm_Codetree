-- 코드를 작성해주세요
select p.ID, count(c.ID) as CHILD_COUNT
from ECOLI_DATA p left outer join ECOLI_DATA c on p.ID = c.PARENT_ID
group by p.ID
order by P.ID ASC;