-- 코드를 작성해주세요
select c.id
from ECOLI_DATA o join ECOLI_DATA p join ECOLI_DATA c on o.id = p.PARENT_ID and p.id = c.PARENT_ID
where o.PARENT_ID is NULL
order by id