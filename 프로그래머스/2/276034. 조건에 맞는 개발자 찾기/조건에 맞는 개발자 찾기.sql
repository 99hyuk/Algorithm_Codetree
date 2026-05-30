-- 코드를 작성해주세요
select distinct ID,	EMAIL,	FIRST_NAME,	LAST_NAME
from DEVELOPERS d join SKILLCODES s on d.SKILL_CODE & s.CODE > 0
where NAME = 'Python' or NAME = 'C#'
order by id;