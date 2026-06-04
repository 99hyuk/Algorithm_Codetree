select Year(e.DIFFERENTIATION_DATE) as YEAR, d.mm - e.SIZE_OF_COLONY as YEAR_DEV, ID
from ecoli_data e join (select YEAR(DIFFERENTIATION_DATE) as YEAR, max(size_of_colony) as mm from ecoli_data group by YEAR(DIFFERENTIATION_DATE)) d
on Year(e.DIFFERENTIATION_DATE) = d.YEAR
order by YEAR ASC, YEAR_DEV ASC;