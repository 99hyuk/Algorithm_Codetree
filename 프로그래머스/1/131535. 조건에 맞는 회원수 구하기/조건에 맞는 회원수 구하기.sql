-- 코드를 입력하세요
SELECT count(USER_ID)
from USER_INFO
where year(joined) = 2021 and age >= 20 and age <= 29;