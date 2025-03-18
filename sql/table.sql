create database CSDLPTTH_08
go
use CSDLPTTH_08
go

CREATE TABLE DuHocSinh (
    MADHS VARCHAR(10) PRIMARY KEY,
    HOTEN VARCHAR(100),
    DIACHI VARCHAR(255),
    DIEMTB FLOAT,
    IELTS FLOAT,
    TAICHINH FLOAT,
    DONVI VARCHAR(10)
);
go
CREATE TABLE TruongHoc (
    MATR VARCHAR(10) PRIMARY KEY,
    TENTRUONG VARCHAR(255),
    QUOCGIA VARCHAR(100),
    HOCPHI INT
);
go
CREATE TABLE NganhHoc (
    MANG VARCHAR(10) PRIMARY KEY,
    TENNGANH VARCHAR(255),
    IELTS FLOAT,
    SONAM INT
);
go
CREATE TABLE DangKyDuHoc (
    MADHS VARCHAR(10),
    MATR VARCHAR(10),
    MANG VARCHAR(10),
    TGDANGKY DATE,
    TGHOC DATE,
    PRIMARY KEY (MADHS, MATR, MANG),
    FOREIGN KEY (MADHS) REFERENCES DuHocSinh(MADHS),
    FOREIGN KEY (MATR) REFERENCES TruongHoc(MATR),
    FOREIGN KEY (MANG) REFERENCES NganhHoc(MANG)
);
go
INSERT INTO DuHocSinh VALUES 
('HS01', 'Nguyen Hong Dao', '32 Hoang Dieu', 7.6, 6, 1, 'Ty'),
('HS02', 'Le Kim Ngan', '47 Tan Thanh', 7.2, 6.5, 700, 'Trieu'),
('HS03', 'Dinh Toan Thang', '59 Phu Gia', 8, 6.5, 600, 'Trieu'),
('HS04', 'Nguyen The Hanh', '12 Hoang Man', 9.6, 7, 1.5, 'Ty'),
('HS05', 'Ly Minh Thu', '15 duong 3/2', 7.5, 6.5, 1.3, 'Ty'),
('HS06', 'Ho Ai Loc', '6 Minh Khue', 5.5, 6.5, 500, 'Trieu');
INSERT INTO TruongHoc VALUES 
('HL01', 'The Hague University of Applied Science', 'Ha Lan', 8000),
('NU01', 'Nord University', 'Nauy', 925),
('HL02', 'Amsterdam University of Applied Sciences', 'Ha Lan', 9800),
('NU02', 'University of Oslo', 'Nauy', 8000),
('TD01', 'Dai hoc Lund', 'Thuy Dien', 435900),
('TD02', 'Dai hoc Karlstad', 'Thuy Dien', 13000);
INSERT INTO NganhHoc VALUES 
('TTM', 'Nganh Truyen thong – Marketing', 6, 3),
('TMQT', 'Nganh Thuong mai Quoc te', 6.5, 4),
('DS', 'Nganh Tri tue nhan tao (AI), Big Data', 6, 4),
('NHKS', 'Nganh Dich vu nha hang, khach san', 7, 3),
('CKBD', 'Nganh Ky thuat, cong nghe, co khi, ban dan', 6.5, 4),
('CNVLM', 'Nganh Cong nghe moi, vat lieu moi', 6.5, 4);
INSERT INTO DangKyDuHoc VALUES 
('HS01', 'HL01', 'TTM', '2024-03-11', '2025-01-01'),
('HS02', 'NU01', 'TTM', '2024-03-12', '2025-01-01'),
('HS03', 'HL02', 'TTM', '2024-03-11', '2025-01-01'),
('HS04', 'NU02', 'TMQT', '2024-03-12', '2025-01-01'),
('HS05', 'TD01', 'TMQT', '2024-03-11', '2025-01-01'),
('HS06', 'TD02', 'NHKS', '2024-03-11', '2025-01-01'),
('HS01', 'TD01', 'DS', '2024-03-11', '2025-09-01'),
('HS02', 'TD02', 'DS', '2024-03-12', '2025-01-09'),
('HS03', 'HL01', 'DS', '2024-03-11', '2025-01-01'),
('HS04', 'HL01', 'TMQT', '2024-03-12', '2025-01-01'),
('HS05', 'HL01', 'TMQT', '2024-03-11', '2025-01-01'),
('HS06', 'HL01', 'CKBD', '2024-03-12', '2025-01-01'),
('HS01', 'NU02', 'DS', '2024-03-11', '2025-02-01'),
('HS02', 'NU02', 'DS', '2024-03-12', '2025-01-01'),
('HS03', 'NU01', 'DS', '2024-03-11', '2025-01-01'),
('HS04', 'NU01', 'CNVLM', '2024-03-12', '2025-01-01');

--Trường học
SELECT * FROM TruongHoc
SELECT * FROM TruongHoc_1
SELECT * FROM TruongHoc_2
SELECT * FROM TruongHoc_3
SELECT * FROM TruongHoc_4

-- Du học sinh 
SELECT * FROM DuHocSinh
SELECT * FROM DuHocSinh_1
SELECT * FROM DuHocSinh_2
SELECT * FROM DuHocSinh_3

-- Ngành học
SELECT * FROM NganhHoc
SELECT * FROM NganhHoc_1
SELECT * FROM NganhHoc_2

-- Du học sinh đăng ký
SELECT * FROM DangKyDuHoc
SELECT * FROM DangKy_1
SELECT * FROM DangKy_2
SELECT * FROM DangKy_3

-- Tạo user
use CSDLPTTH_08;
GO
CREATE LOGIN csdlpt8_1 WITH PASSWORD = 'csdlpt8_1@';
go
CREATE USER csdlpt8_1 FOR LOGIN csdlpt8_1;
go
GRANT select,insert,update,delete,execute TO csdlpt8_1;

SELECT DuHocSinh.HOTEN,DuHocSinh.IELTS,TruongHoc.TENTRUONG,TruongHoc.QUOCGIA,DangKyDuHoc.TGHOC FROM DangKyDuHoc 
inner join TruongHoc on DangKyDuHoc.MATR = TruongHoc.MATR 
inner join DuHocSinh on DangKyDuHoc.MADHS = DuHocSinh.MADHS
WHERE TENTRUONG = 'Dai hoc Lund'

SELECT 
    DuHocSinh.MADHS, 
    DuHocSinh.HOTEN, 
    NganhHoc.MANG, 
    DuHocSinh.IELTS, 
    NganhHoc.IELTS 
FROM DangKyDuHoc 
INNER JOIN NganhHoc ON DangKyDuHoc.MANG = NganhHoc.MANG
INNER JOIN DuHocSinh ON DangKyDuHoc.MADHS = DuHocSinh.MADHS
WHERE DuHocSinh.IELTS < NganhHoc.IELTS;

