-- 코드를 입력하세요
SELECT distinct c.CAR_ID,	c.CAR_TYPE,	(c.DAILY_FEE * ((100-DISCOUNT_RATE) / 100) * 30) as FEE
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY h on c.car_id = h.car_id
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.car_type = p.car_type
where (c.CAR_TYPE = '세단' or c.CAR_TYPE = 'SUV') 
and NOT EXISTS (
      SELECT 1
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
      WHERE h.CAR_ID = c.CAR_ID
        AND h.START_DATE <= '2022-11-30'
        AND h.END_DATE >= '2022-11-01'
  )
and (DURATION_TYPE like '30%')
and (c.DAILY_FEE * ((100-DISCOUNT_RATE) / 100) * 30) >= 500000
and (c.DAILY_FEE * ((100-DISCOUNT_RATE) / 100) * 30) < 2000000
order by (c.DAILY_FEE * ((100-DISCOUNT_RATE) / 100) * 30) desc,c.car_type asc, c.car_id DESC;