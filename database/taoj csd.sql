USE VTTVShop;
GO

INSERT INTO [dbo].[sanpham] (TenSP, Gia, Anh, [thuong_hieu],[mo_ta] , [so_luong], [kich_co], [mau_sac])
VALUES 
(N'Adidas Ultra Boost 22', 4500000, 'pr1.jpg', 'Adidas', N'Giày chạy bộ công nghệ Boost siêu êm.', 50, '39,40,41,42', N'Trắng, Đen'),
(N'Nike Air Force 1 Low', 3200000, 'pr2.jpg', 'Nike', N'Huyền thoại đường phố, màu trắng classic.', 100, '38,39,40,41', N'Trắng'),
(N'MLB Chunky Liner', 1800000, 'pr3.jpg', 'MLB', N'Giày sneaker đế độn phong cách Hàn Quốc.', 80, '36,37,38', N'Trắng ngà'),
(N'Converse Chuck 70s', 1500000, 'pr4.jpg', 'Converse', N'Vải canvas dày dặn, đế ngà vintage.', 120, '36,37,38,39,40', N'Đen, Vàng'),
(N'Vans Old Skool', 1650000, 'pr5.jpg', 'Vans', N'Dòng giày trượt ván kinh điển sọc Jazz.', 90, '36,37,38,39', N'Đen trắng'),
(N'New Balance 530', 2100000, 'pr6.jpg', 'New Balance', N'Phong cách Dad shoes cổ điển, thoáng khí.', 60, '38,39,40', N'Xám bạc'),
(N'Sandal Vento', 350000, 'pr7.jpg', 'Vento', N'Sandal quai dù bền bỉ, đi mưa thoải mái.', 300, '38,39,40,41', N'Xám rêu'),
(N'Dép Adidas Adilette', 850000, 'pr8.jpg', 'Adidas', N'Dép đúc nguyên khối, chống nước.', 200, '38,39,40,41', N'Xanh Navy'),
(N'Giày Tây Oxford', 2500000, 'pr9.jpg', 'Pierre Cardin', N'Da bò thật 100%, lịch lãm công sở.', 40, '39,40,41,42', N'Đen, Nâu'),
(N'Giày Cao Gót', 550000, 'pr10.jpg', 'Juno', N'Gót nhọn 7cm tôn dáng, da bóng.', 60, '35,36,37', N'Đen, Đỏ'),
(N'Chelsea Boot', 1250000, 'pr11.jpg', 'Zara', N'Bốt cổ lửng phong cách bụi bặm.', 45, '40,41,42', N'Nâu, Be'),
(N'Dép Crocs Classic', 1100000, 'pr12.jpg', 'Crocs', N'Siêu nhẹ, có quai hậu linh hoạt.', 150, '35,36,37,38', N'Trắng, Xanh');
GO

USE VTTVShop;
select * from [dbo].[sanpham];