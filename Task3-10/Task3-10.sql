-- 1. Staffテーブルから「経理部」に所属する社員の情報をすべて抽出してください
SELECT * from staff WHERE section='経理部';

-- 2. 在庫(Stocksテーブル)の在庫数(Quantity)が10以上25未満のものを抽出して下さい。
SELECT * FROM stocks
WHERE Quantity <= 25 AND Quantity >= 10;

-- 3. INTERSECT演算子を使用して、Order_Headerテーブルで合計値(Total)が5000以上10000未満のものを抽出して下さい。
SELECT A.Total FROM Order_Header A WHERE A.Total > 5000
INTERSECT
SELECT B.Total FROM Order_Header B WHERE B.Total < 10000;

-- 4. 「関東」エリアの全店舗情報を抽出して下さい。
SELECT * FROM area JOIN shop ON area.areacode = shop.areacode WHERE areaname ='関東';

-- 5. 在庫(Stocksテーブル)内の各商品の合計数量を抽出して下さい
SELECT SUM(quantity),goodsname FROM stocks JOIN Goods ON stocks.goodscode = Goods.goodscode
GROUP BY goodsname;

-- 6. 商品（Goods）テーブルから単価（UnitPrice)が5000円より高い商品の情報を全て抽出して下さい。
SELECT * FROM Goods
WHERE UnitPrice >5000;

-- 7. Shopテーブルの全ての店舗コード（Shopcode）、店舗名（Shopname）を、所在地（areaname）とあわせて抽出してください。
SELECT Shopcode,Shopname,areaname FROM area JOIN shop ON area.areacode = shop.areacode;

-- 8. 「新宿」店の在庫数が10以上の商品の商品コード（goodsCode）、商品名（goodsName）、在庫数（quantity）を抽出して下さい
SELECT goods.goodsCode,goodsName,quantity FROM stocks
JOIN shop ON shop.shopCode = stocks.shopCode
JOIN goods ON goods.goodsCode = stocks.goodsCode
WHERE shopname ='新宿'AND Quantity >= 10;