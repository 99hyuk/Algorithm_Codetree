-- 코드를 작성해주세요
select d.DEPT_ID,	DEPT_NAME_EN, round(avg(sal)) as AVG_SAL
from HR_DEPARTMENT d join HR_EMPLOYEES e on d.dept_id = e.dept_id
group by dept_id
order by AVG_SAL DESC;