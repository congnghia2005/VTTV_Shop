ALTER TABLE [dbo].[sanpham]
ALTER COLUMN thuong_hieu NVARCHAR(255);

ALTER TABLE [dbo].[sanpham]
ALTER COLUMN mau_sac NVARCHAR(200);

ALTER TABLE [dbo].[sanpham]
ALTER COLUMN mo_ta NVARCHAR(MAX);

ALTER TABLE [dbo].[sanpham]
ALTER COLUMN anh NVARCHAR(255);

ALTER TABLE [dbo].[sanpham]
ALTER COLUMN tensp NVARCHAR(255);

ALTER TABLE [dbo].[sanpham]
ALTER COLUMN kich_co NVARCHAR(255);


SELECT * FROM [dbo].[sanpham]