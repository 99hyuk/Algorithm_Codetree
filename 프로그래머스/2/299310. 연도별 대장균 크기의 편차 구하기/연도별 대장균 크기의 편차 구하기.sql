-- 코드를 작성해주세요
select year(DIFFERENTIATION_DATE) as YEAR, (m - SIZE_OF_COLONY) as YEAR_DEV, ID
from ECOLI_DATA a 
join (select year(DIFFERENTIATION_DATE) as y, max(SIZE_OF_COLONY) as m from ECOLI_DATA group by year(DIFFERENTIATION_DATE)) b 
on year(a.DIFFERENTIATION_DATE) = y
order by YEAR ASC, YEAR_DEV ASC;