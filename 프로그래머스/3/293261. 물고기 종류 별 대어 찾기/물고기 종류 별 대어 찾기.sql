-- 코드를 작성해주세요
select ID,	FISH_NAME,	LENGTH
from FISH_INFO i join FISH_NAME_INFO n on i.fish_type = n.fish_type
where (i.fish_type, i.length) in (select j.fish_type, max(length) from fish_info j group by j.fish_type) 
order by id;