USE [master]
GO
/****** Object:  Database [ManagerHR]    Script Date: 3/5/2020 12:27:22 PM ******/
CREATE DATABASE [ManagerHR]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ManagerHR', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ManagerHR.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ManagerHR_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ManagerHR_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ManagerHR] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ManagerHR].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ManagerHR] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ManagerHR] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ManagerHR] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ManagerHR] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ManagerHR] SET ARITHABORT OFF 
GO
ALTER DATABASE [ManagerHR] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [ManagerHR] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ManagerHR] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ManagerHR] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ManagerHR] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ManagerHR] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ManagerHR] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ManagerHR] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ManagerHR] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ManagerHR] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ManagerHR] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ManagerHR] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ManagerHR] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ManagerHR] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ManagerHR] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ManagerHR] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ManagerHR] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ManagerHR] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ManagerHR] SET  MULTI_USER 
GO
ALTER DATABASE [ManagerHR] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ManagerHR] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ManagerHR] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ManagerHR] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ManagerHR] SET DELAYED_DURABILITY = DISABLED 
GO
USE [ManagerHR]
GO
/****** Object:  Table [dbo].[tblContracts]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblContracts](
	[Id] [varchar](5) NOT NULL,
	[DateSign] [date] NULL,
	[DateExpied] [date] NULL,
	[ContenContract] [ntext] NULL,
	[StatusContract] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblDeparment]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblDeparment](
	[IdDepartment] [varchar](5) NOT NULL,
	[NameDepartment] [nvarchar](128) NULL,
	[PhoneDep] [varchar](16) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDepartment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblDisciplineReward]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblDisciplineReward](
	[Id] [varchar](5) NOT NULL,
	[NameDis] [nvarchar](128) NULL,
	[StatusDisciplineReward] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblDistrict]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblDistrict](
	[IdDistrict] [varchar](5) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Type] [nvarchar](100) NULL,
	[IdCity] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDistrict] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblDREmp]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblDREmp](
	[IdEmp] [varchar](5) NULL,
	[Id] [varchar](5) NULL,
	[DateDR] [date] NULL,
	[Reson] [nvarchar](256) NULL,
	[Content] [nvarchar](256) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblEmployee]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblEmployee](
	[IdEmp] [varchar](5) NOT NULL,
	[Username] [varchar](128) NULL,
	[Pass] [varchar](128) NULL,
	[NameEmp] [nvarchar](128) NULL,
	[BirthdayEmp] [date] NULL,
	[Sex] [bit] NULL,
	[StatusMarriage] [tinyint] NULL,
	[PhoneEmp] [varchar](11) NULL,
	[AddressEmp] [nvarchar](256) NULL,
	[IdentityEmp] [varchar](12) NULL,
	[IdProvince] [varchar](5) NULL,
	[IdDistrict] [varchar](5) NULL,
	[IdWard] [varchar](5) NULL,
	[IdReligion] [varchar](5) NULL,
	[IdEthnic] [varchar](5) NULL,
	[IdRankSalary] [int] NULL,
	[IdSalaryBasic] [varchar](1) NULL,
	[IdContract] [varchar](5) NULL,
	[IdRole] [int] NULL,
	[Insurance] [bit] NULL,
	[IdDepartment] [varchar](5) NULL,
	[IdPosition] [varchar](5) NULL,
	[LevelEdu] [int] NULL,
	[LanguageMaster] [nvarchar](128) NULL,
	[DayOff] [int] NULL DEFAULT ((12)),
	[NoteEmp] [nvarchar](256) NULL,
	[Avarta] [varchar](512) NULL,
	[StatusEmp] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEmp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblEmployeeRe]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblEmployeeRe](
	[IdEmpRe] [varchar](5) NOT NULL,
	[NameEmp] [nvarchar](128) NULL,
	[BirthdayEmp] [date] NULL,
	[Sex] [bit] NULL,
	[StatusMarriage] [tinyint] NULL,
	[PhoneEmp] [varchar](11) NULL,
	[AddressEmp] [nvarchar](256) NULL,
	[IdentityEmp] [varchar](12) NULL,
	[IdProvince] [varchar](5) NULL,
	[IdDistrict] [varchar](5) NULL,
	[IdWard] [varchar](5) NULL,
	[IdReligion] [varchar](5) NULL,
	[IdEthnic] [varchar](5) NULL,
	[IdDepartment] [varchar](5) NULL,
	[IdPosition] [varchar](5) NULL,
	[IdContract] [varchar](5) NULL,
	[LevelEdu] [int] NULL,
	[LanguageMaster] [nvarchar](128) NULL,
	[NoteEmp] [nvarchar](256) NULL,
	[Avarta] [varchar](512) NULL,
	[StatusEmp] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEmpRe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblEmpPro]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblEmpPro](
	[IdEmp] [varchar](5) NOT NULL,
	[IdPro] [varchar](5) NOT NULL,
	[Status] [nvarchar](512) NULL,
	[dateJoin] [date] NULL,
	[Roles] [tinyint] NULL,
 CONSTRAINT [PK_EmpPro] PRIMARY KEY CLUSTERED 
(
	[IdEmp] ASC,
	[IdPro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblEthnic]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblEthnic](
	[IdEthnic] [varchar](5) NOT NULL,
	[Name] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEthnic] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblLevelEdu]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblLevelEdu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[NameEdu] [nvarchar](128) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPayroll]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblPayroll](
	[IdEmp] [varchar](5) NOT NULL,
	[MonthPay] [nvarchar](10) NOT NULL,
	[CountTime] [int] NULL,
	[RankSalary] [float] NULL,
	[SalaryBasic] [float] NULL,
	[TotalSalary] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEmp] ASC,
	[MonthPay] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblPosition]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblPosition](
	[IdPosition] [varchar](5) NOT NULL,
	[NamePosition] [nvarchar](128) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPosition] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblProject]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblProject](
	[Id] [varchar](5) NOT NULL,
	[NamePro] [nvarchar](256) NULL,
	[ContentPro] [nvarchar](500) NULL,
	[DateSign] [date] NULL,
	[DateDeadline] [date] NULL,
	[ValPro] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblProvince]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblProvince](
	[IdCity] [varchar](5) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Type] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCity] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblRankSalary]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRankSalary](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdSpecialized] [int] NULL,
	[NameRank] [nvarchar](50) NULL,
	[Coefficient] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRankSalaryBasic]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblRankSalaryBasic](
	[Id] [varchar](1) NOT NULL,
	[SalaryBasic] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblReligion]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblReligion](
	[IdReligion] [varchar](5) NOT NULL,
	[Name] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdReligion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRole](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[NameAccess] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblSpecialized]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSpecialized](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[NameSpecial] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblStatusContract]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblStatusContract](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[StatusContractName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblTimekeeping]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblTimekeeping](
	[IdEmp] [varchar](5) NOT NULL,
	[DateTimekeeping] [date] NOT NULL,
	[Status] [bit] NULL,
	[Note] [nvarchar](128) NULL,
 CONSTRAINT [PK_Time] PRIMARY KEY CLUSTERED 
(
	[DateTimekeeping] ASC,
	[IdEmp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblWards]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblWards](
	[IdWard] [varchar](5) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Type] [nvarchar](100) NULL,
	[IdDistrict] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdWard] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[tblContracts]  WITH CHECK ADD FOREIGN KEY([StatusContract])
REFERENCES [dbo].[tblStatusContract] ([Id])
GO
ALTER TABLE [dbo].[tblDistrict]  WITH CHECK ADD FOREIGN KEY([IdCity])
REFERENCES [dbo].[tblProvince] ([IdCity])
GO
ALTER TABLE [dbo].[tblDREmp]  WITH CHECK ADD FOREIGN KEY([Id])
REFERENCES [dbo].[tblDisciplineReward] ([Id])
GO
ALTER TABLE [dbo].[tblDREmp]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[tblEmployee] ([IdEmp])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdContract])
REFERENCES [dbo].[tblContracts] ([Id])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdDepartment])
REFERENCES [dbo].[tblDeparment] ([IdDepartment])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdDistrict])
REFERENCES [dbo].[tblDistrict] ([IdDistrict])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdEthnic])
REFERENCES [dbo].[tblEthnic] ([IdEthnic])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdPosition])
REFERENCES [dbo].[tblPosition] ([IdPosition])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdProvince])
REFERENCES [dbo].[tblProvince] ([IdCity])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdRankSalary])
REFERENCES [dbo].[tblRankSalary] ([Id])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdReligion])
REFERENCES [dbo].[tblReligion] ([IdReligion])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdRole])
REFERENCES [dbo].[tblRole] ([Id])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdSalaryBasic])
REFERENCES [dbo].[tblRankSalaryBasic] ([Id])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([IdWard])
REFERENCES [dbo].[tblWards] ([IdWard])
GO
ALTER TABLE [dbo].[tblEmployee]  WITH CHECK ADD FOREIGN KEY([LevelEdu])
REFERENCES [dbo].[tblLevelEdu] ([Id])
GO
ALTER TABLE [dbo].[tblEmployeeRe]  WITH CHECK ADD FOREIGN KEY([IdContract])
REFERENCES [dbo].[tblContracts] ([Id])
GO
ALTER TABLE [dbo].[tblEmployeeRe]  WITH CHECK ADD FOREIGN KEY([IdDepartment])
REFERENCES [dbo].[tblDeparment] ([IdDepartment])
GO
ALTER TABLE [dbo].[tblEmployeeRe]  WITH CHECK ADD FOREIGN KEY([IdDistrict])
REFERENCES [dbo].[tblDistrict] ([IdDistrict])
GO
ALTER TABLE [dbo].[tblEmployeeRe]  WITH CHECK ADD FOREIGN KEY([IdEthnic])
REFERENCES [dbo].[tblEthnic] ([IdEthnic])
GO
ALTER TABLE [dbo].[tblEmployeeRe]  WITH CHECK ADD FOREIGN KEY([IdPosition])
REFERENCES [dbo].[tblPosition] ([IdPosition])
GO
ALTER TABLE [dbo].[tblEmployeeRe]  WITH CHECK ADD FOREIGN KEY([IdProvince])
REFERENCES [dbo].[tblProvince] ([IdCity])
GO
ALTER TABLE [dbo].[tblEmployeeRe]  WITH CHECK ADD FOREIGN KEY([IdReligion])
REFERENCES [dbo].[tblReligion] ([IdReligion])
GO
ALTER TABLE [dbo].[tblEmployeeRe]  WITH CHECK ADD FOREIGN KEY([IdWard])
REFERENCES [dbo].[tblWards] ([IdWard])
GO
ALTER TABLE [dbo].[tblEmployeeRe]  WITH CHECK ADD FOREIGN KEY([LevelEdu])
REFERENCES [dbo].[tblLevelEdu] ([Id])
GO
ALTER TABLE [dbo].[tblEmpPro]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[tblEmployee] ([IdEmp])
GO
ALTER TABLE [dbo].[tblEmpPro]  WITH CHECK ADD FOREIGN KEY([IdPro])
REFERENCES [dbo].[tblProject] ([Id])
GO
ALTER TABLE [dbo].[tblPayroll]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[tblEmployee] ([IdEmp])
GO
ALTER TABLE [dbo].[tblRankSalary]  WITH CHECK ADD FOREIGN KEY([IdSpecialized])
REFERENCES [dbo].[tblSpecialized] ([Id])
GO
ALTER TABLE [dbo].[tblTimekeeping]  WITH CHECK ADD FOREIGN KEY([IdEmp])
REFERENCES [dbo].[tblEmployee] ([IdEmp])
GO
ALTER TABLE [dbo].[tblWards]  WITH CHECK ADD FOREIGN KEY([IdDistrict])
REFERENCES [dbo].[tblDistrict] ([IdDistrict])
GO
/****** Object:  StoredProcedure [dbo].[getAllPayroll]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getAllPayroll]
@iddep varchar(5),
@month nvarchar(10)
as
SELECT        dbo.tblPayroll.IdEmp, dbo.tblEmployee.NameEmp, dbo.tblPayroll.CountTime, dbo.tblPayroll.RankSalary, dbo.tblPayroll.SalaryBasic, dbo.tblPayroll.TotalSalary
FROM            dbo.tblPayroll INNER JOIN
                         dbo.tblEmployee ON dbo.tblPayroll.IdEmp = dbo.tblEmployee.IdEmp INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment
where tblEmployee.IdDepartment=@iddep and tblPayroll.MonthPay=@month

GO
/****** Object:  StoredProcedure [dbo].[getContract]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getContract]
as
select * from tblContracts

GO
/****** Object:  StoredProcedure [dbo].[getcountLv]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getcountLv]
@iddep varchar(5)
as

SELECT        dbo.tblLevelEdu.NameEdu, COUNT(dbo.tblEmployee.LevelEdu) AS 'Count'
FROM            dbo.tblEmployee INNER JOIN
                         dbo.tblLevelEdu ON dbo.tblEmployee.LevelEdu = dbo.tblLevelEdu.Id INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment
where dbo.tblEmployee.IdDepartment = @iddep
GROUP BY dbo.tblLevelEdu.NameEdu
order by dbo.tblLevelEdu.NameEdu

GO
/****** Object:  StoredProcedure [dbo].[getDeparment]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[getDeparment]
as
select * from tblDeparment

GO
/****** Object:  StoredProcedure [dbo].[getDisciplineReward]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getDisciplineReward]
as
select * from tblDisciplineReward 

GO
/****** Object:  StoredProcedure [dbo].[getDistrict]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getDistrict]
@idcity varchar(5)
as
select * from tblDistrict inner join tblProvince on tblProvince.IdCity = tblDistrict.IdCity where tblProvince.IdCity = @idcity

GO
/****** Object:  StoredProcedure [dbo].[getEmp]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[getEmp]
@idDep varchar(5)
as
SELECT        dbo.tblEmployee.IdEmp, dbo.tblEmployee.NameEmp, dbo.tblPosition.NamePosition, dbo.tblDeparment.NameDepartment
FROM            dbo.tblDeparment INNER JOIN
                         dbo.tblEmployee ON dbo.tblDeparment.IdDepartment = dbo.tblEmployee.IdDepartment INNER JOIN
                         dbo.tblPosition ON dbo.tblEmployee.IdPosition = dbo.tblPosition.IdPosition
WHERE tblEmployee.IdDepartment = @idDep

GO
/****** Object:  StoredProcedure [dbo].[getEmpbyStatus]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getEmpbyStatus]
@statusEmp bit
as
select * from tblEmployee where statusEmp=@statusEmp

GO
/****** Object:  StoredProcedure [dbo].[getEmpd]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getEmpd]
@iddep varchar(5),
@month nvarchar(10),
@idemp varchar(5)
as
SELECT        dbo.tblPayroll.IdEmp, dbo.tblEmployee.NameEmp, dbo.tblPayroll.CountTime, dbo.tblPayroll.RankSalary, dbo.tblPayroll.SalaryBasic, dbo.tblPayroll.TotalSalary
FROM            dbo.tblPayroll INNER JOIN
                         dbo.tblEmployee ON dbo.tblPayroll.IdEmp = dbo.tblEmployee.IdEmp INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment
where tblEmployee.IdDepartment=@iddep and tblPayroll.MonthPay=@month and tblPayroll.IdEmp=@idemp

GO
/****** Object:  StoredProcedure [dbo].[getEmpDR]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getEmpDR]
@iddep varchar(5)
as
SELECT        dbo.tblDREmp.IdEmp, dbo.tblDREmp.Id, dbo.tblEmployee.NameEmp, dbo.tblDeparment.NameDepartment, dbo.tblPosition.NamePosition, dbo.tblDREmp.DateDR, dbo.tblDREmp.Reson, 
                         dbo.tblDREmp.[Content]
FROM            dbo.tblDREmp INNER JOIN
                         dbo.tblEmployee ON dbo.tblDREmp.IdEmp = dbo.tblEmployee.IdEmp INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment INNER JOIN
                         dbo.tblPosition ON dbo.tblEmployee.IdPosition = dbo.tblPosition.IdPosition INNER JOIN
                         dbo.tblDisciplineReward ON dbo.tblDREmp.Id = dbo.tblDisciplineReward.Id
where tblEmployee.IdDepartment = @iddep

GO
/****** Object:  StoredProcedure [dbo].[getEmployee]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getEmployee]
@stt int
as
select * from tblEmployee WHERE StatusEmp = @stt
GO
/****** Object:  StoredProcedure [dbo].[getEmployeeRe]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getEmployeeRe]
@stt int
as
select * from tblEmployeeRe WHERE StatusEmp =@stt

GO
/****** Object:  StoredProcedure [dbo].[getEmpRebyStatus]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getEmpRebyStatus]
@statusEmp bit
as
select * from tblEmployeeRe where StatusEmp=@statusEmp

GO
/****** Object:  StoredProcedure [dbo].[getEpTP]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getEpTP]
@Tp varchar(5)
as
SELECT        dbo.tblEmployee.IdEmp, dbo.tblEmployee.NameEmp, dbo.tblPosition.NamePosition, dbo.tblDeparment.NameDepartment
FROM            dbo.tblDeparment INNER JOIN
                         dbo.tblEmployee ON dbo.tblDeparment.IdDepartment = dbo.tblEmployee.IdDepartment INNER JOIN
                         dbo.tblPosition ON dbo.tblEmployee.IdPosition = dbo.tblPosition.IdPosition
						 where  dbo.tblPosition.IdPosition=@Tp

GO
/****** Object:  StoredProcedure [dbo].[getEthnic]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getEthnic]
as
select * from tblEthnic

GO
/****** Object:  StoredProcedure [dbo].[getLevelEdu]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getLevelEdu] 
as
select * from tblLevelEdu

GO
/****** Object:  StoredProcedure [dbo].[getMoth]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getMoth]
as
SELECT        dbo.tblPayroll.MonthPay
FROM            dbo.tblDeparment INNER JOIN
                         dbo.tblEmployee ON dbo.tblDeparment.IdDepartment = dbo.tblEmployee.IdDepartment INNER JOIN
                         dbo.tblPayroll ON dbo.tblEmployee.IdEmp = dbo.tblPayroll.IdEmp
group by MonthPay

GO
/****** Object:  StoredProcedure [dbo].[getPosition]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getPosition]
as
select * from tblPosition

GO
/****** Object:  StoredProcedure [dbo].[getProvince]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getProvince]
as
select * from tblProvince

GO
/****** Object:  StoredProcedure [dbo].[getReligion]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getReligion]
as
Select * from tblReligion

GO
/****** Object:  StoredProcedure [dbo].[getRole]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getRole]
as
select * from tblRole order by Id DESC

GO
/****** Object:  StoredProcedure [dbo].[getWards]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getWards]
@idpr varchar(5)
as
select * from tblWards inner join tblDistrict on tblWards.IdDistrict = tblDistrict.IdDistrict where tblDistrict.IdDistrict = @idpr

GO
/****** Object:  StoredProcedure [dbo].[insertEmpDR]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[insertEmpDR]
@idEmp varchar(5),
@idDR varchar(5),
@DateDR date,
@Reson nvarchar(256),
@Content nvarchar(256)
as
insert into tblDREmp values (@idEmp,
@idDR,
@DateDR,
@Reson,
@Content)

GO
/****** Object:  StoredProcedure [dbo].[insertPayroll]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[insertPayroll]
@idemp varchar(5),
@month nvarchar(10),
@count int,
@rank float,
@salay float,
@total float
as
insert into tblPayroll values (@idemp,@month,@count,@rank,@salay,@total)

GO
/****** Object:  StoredProcedure [dbo].[searchContractByID]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchContractByID] 
@id varchar(5)
as
SELECT        dbo.tblContracts.Id, dbo.tblContracts.DateSign, dbo.tblContracts.DateExpied, dbo.tblContracts.ContenContract, dbo.tblContracts.StatusContract, dbo.tblEmployee.IdEmp, dbo.tblEmployee.NameEmp
FROM            dbo.tblContracts INNER JOIN
                         dbo.tblEmployee ON dbo.tblContracts.Id = dbo.tblEmployee.IdContract where Id = @id

GO
/****** Object:  StoredProcedure [dbo].[sp_checkLogin]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_checkLogin]
@username varchar(128)
as
SELECT        dbo.tblEmployee.IdEmp, dbo.tblEmployee.Username, dbo.tblEmployee.Pass, dbo.tblEmployee.NameEmp, dbo.tblEmployee.IdRole
FROM            dbo.tblEmployee INNER JOIN
                         dbo.tblRole ON dbo.tblEmployee.IdRole = dbo.tblRole.Id
where (IdRole <5 or IdRole>5) and Username like @username

GO
/****** Object:  StoredProcedure [dbo].[sp_CountTime]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_CountTime]

@date1 date,
@date2 date,
@iddep varchar(5)
as

SELECT dbo.tblEmployee.IdEmp, dbo.tblEmployee.NameEmp, dbo.tblPosition.NamePosition, dbo.tblRankSalaryBasic.SalaryBasic, dbo.tblRankSalary.Coefficient,DL 
FROM dbo.tblEmployee INNER JOIN
                         dbo.tblPosition ON dbo.tblEmployee.IdPosition = dbo.tblPosition.IdPosition INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment INNER JOIN
                         dbo.tblRankSalary ON dbo.tblEmployee.IdRankSalary = dbo.tblRankSalary.Id INNER JOIN
                         dbo.tblRankSalaryBasic ON dbo.tblEmployee.IdSalaryBasic = dbo.tblRankSalaryBasic.Id,
(select IdEmp,count(tblTimekeeping.IdEmp) as DL
	from tblTimekeeping 
	where  tblTimekeeping.Status=1 
		and tblTimekeeping.DateTimekeeping between @date1 and @date2 group by tblTimekeeping.IdEmp) as chamcong
WHERE tblEmployee.IdEmp = chamcong.idEmp and tblEmployee.IdDepartment=@iddep

GO
/****** Object:  StoredProcedure [dbo].[sp_Department]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_Department]
as
SELECT        dbo.tblDeparment.*
FROM            dbo.tblDeparment

GO
/****** Object:  StoredProcedure [dbo].[sp_District]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_District]
@id varchar(5)
as
select * from tblDistrict inner join tblProvince on tblDistrict.IdCity = tblProvince.IdCity where tblProvince.IdCity=@id

GO
/****** Object:  StoredProcedure [dbo].[sp_editTimekeep]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_editTimekeep]
@iddep varchar(5),
@date date
as
SELECT        dbo.tblEmployee.NameEmp, dbo.tblDeparment.NameDepartment, dbo.tblPosition.NamePosition, dbo.tblTimekeeping.Status, dbo.tblTimekeeping.Note, dbo.tblTimekeeping.DateTimekeeping, dbo.tblTimekeeping.IdEmp
FROM            dbo.tblTimekeeping INNER JOIN
                         dbo.tblEmployee ON dbo.tblTimekeeping.IdEmp = dbo.tblEmployee.IdEmp INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment INNER JOIN
                         dbo.tblPosition ON dbo.tblEmployee.IdPosition = dbo.tblPosition.IdPosition
						 where tblDeparment.IdDepartment=@iddep and tblTimekeeping.DateTimekeeping=@date

GO
/****** Object:  StoredProcedure [dbo].[sp_EmpbyID]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_EmpbyID]
@id varchar(5)
as
select * from tblEmployee where tblEmployee.IdEmp = @id
------------------------------------------------

GO
/****** Object:  StoredProcedure [dbo].[sp_EmpbyIdContract]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_EmpbyIdContract] 
@idContract varchar(5)
as
select  * from tblEmployee  where IdContract = @idContract

GO
/****** Object:  StoredProcedure [dbo].[sp_GetAllEmpPro]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_GetAllEmpPro]
@id varchar(5)
as
select * from tblEmpPro where tblEmpPro.IdPro='QLNS1'

GO
/****** Object:  StoredProcedure [dbo].[sp_getContract]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getContract]
@status int
as
SELECT  ct.Id, ct.DateSign, ct.DateExpied, ct.ContenContract, dbo.tblStatusContract.StatusContractName,
(Select tblEmployee.IdEmp from tblEmployee where tblEmployee.IdContract=ct.Id) as 'IdEmp',
(Select  tblEmployee.NameEmp from tblEmployee where tblEmployee.IdContract=ct.Id ) as 'NameEmp'
from dbo.tblContracts ct INNER JOIN dbo.tblStatusContract 
	ON ct.StatusContract = dbo.tblStatusContract.Id 
	where tblStatusContract.Id =@status

GO
/****** Object:  StoredProcedure [dbo].[sp_GetEmpforPro]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_GetEmpforPro]
@iddep varchar(5)
as
SELECT        dbo.tblEmployee.IdEmp, dbo.tblEmployee.NameEmp, dbo.tblPosition.NamePosition
FROM            dbo.tblEmployee INNER JOIN
                         dbo.tblPosition ON dbo.tblEmployee.IdPosition = dbo.tblPosition.IdPosition INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment
						 where tblEmployee.IdDepartment = @iddep


GO
/****** Object:  StoredProcedure [dbo].[sp_getEmpsetSalary]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getEmpsetSalary]
@idep varchar(5)
as
SELECT        dbo.tblEmployee.IdEmp, dbo.tblEmployee.NameEmp, dbo.tblPosition.NamePosition, dbo.tblRankSalary.NameRank, dbo.tblRankSalary.Coefficient, dbo.tblSpecialized.NameSpecial, dbo.tblRankSalaryBasic.Id, 
                         dbo.tblRankSalaryBasic.SalaryBasic
FROM            dbo.tblEmployee INNER JOIN
                         dbo.tblRankSalary ON dbo.tblEmployee.IdRankSalary = dbo.tblRankSalary.Id INNER JOIN
                         dbo.tblRankSalaryBasic ON dbo.tblEmployee.IdSalaryBasic = dbo.tblRankSalaryBasic.Id INNER JOIN
                         dbo.tblPosition ON dbo.tblEmployee.IdPosition = dbo.tblPosition.IdPosition INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment INNER JOIN
                         dbo.tblSpecialized ON dbo.tblRankSalary.IdSpecialized = dbo.tblSpecialized.Id
where	tblEmployee.IdDepartment=@idep

GO
/****** Object:  StoredProcedure [dbo].[sp_getEmpTimekeeping]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getEmpTimekeeping]
@iddep varchar(5)
as
SELECT        dbo.tblEmployee.IdEmp, dbo.tblEmployee.NameEmp, dbo.tblDeparment.NameDepartment, dbo.tblPosition.NamePosition
FROM            dbo.tblEmployee INNER JOIN
                         dbo.tblPosition ON dbo.tblEmployee.IdPosition = dbo.tblPosition.IdPosition INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment
						 where tblEmployee.IdDepartment = @iddep

GO
/****** Object:  StoredProcedure [dbo].[sp_getNameRank]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getNameRank]
@idspce int
as
select * from tblRankSalary inner join tblSpecialized on tblRankSalary.IdSpecialized=tblSpecialized.Id
where tblRankSalary.IdSpecialized=@idspce

GO
/****** Object:  StoredProcedure [dbo].[sp_getNumDayoff]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getNumDayoff]
@id varchar(5)
as
SELECT tblEmployee.DayOff from tblEmployee where IdEmp = @id

GO
/****** Object:  StoredProcedure [dbo].[sp_getPro]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getPro]
as
select * from tblProject

GO
/****** Object:  StoredProcedure [dbo].[sp_getRolleUser]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getRolleUser]
@id varchar(5)
as
select * from tblEmployee where IdEmp=@id

GO
/****** Object:  StoredProcedure [dbo].[sp_getSalaryBasic]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getSalaryBasic]
as
select * from tblRankSalaryBasic

GO
/****** Object:  StoredProcedure [dbo].[sp_getSpecialized]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getSpecialized]
as
select * from tblSpecialized

GO
/****** Object:  StoredProcedure [dbo].[sp_getStatusContract]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_getStatusContract]
as
select * from tblStatusContract

GO
/****** Object:  StoredProcedure [dbo].[sp_iforDep]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_iforDep]
as
SELECT * ,
(Select tblEmployee.NameEmp from tblEmployee where tblEmployee.IdDepartment=pb.IdDepartment and (tblEmployee.IdPosition='TP001' OR tblEmployee.IdPosition='GD001'OR tblEmployee.IdPosition='GD002' )) as'TP',
(Select tblEmployee.NameEmp from tblEmployee where tblEmployee.IdDepartment=pb.IdDepartment and tblEmployee.IdPosition='TP002') as'PP'

from tblDeparment pb
GO
/****** Object:  StoredProcedure [dbo].[sp_insertEmp]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_insertEmp]
@IdEmp varchar(5) ,
@Username varchar(128),
@Pass varchar(128),
@NameEmp nvarchar(128),
@BirthdayEmp date,
@Sex bit,
@StatusMarriage tinyint,
@PhoneEmp varchar(11),
@AddressEmp nvarchar(256),
@IdentityEmp varchar(12),
@IdProvince varchar(5) ,
@IdDistrict varchar(5)  ,
@IdWard varchar(5),
@IdReligion varchar(5),
@IdEthnic varchar(5),
@IdRankSalary int ,
@IdSalaryBasic varchar(1),
@IdContract varchar(5),
@IdRole int,
@Insurance bit,
@IdDepartment varchar(5),
@IdPosition varchar(5),
@LevelEdu int ,
@LanguageMaster nvarchar(128),
@DayOff int,
@NoteEmp nvarchar(256),
@Avarta varchar(512)
as
insert into tblEmployee values (@IdEmp,@Username ,@Pass,@NameEmp,@BirthdayEmp,@Sex,@StatusMarriage,@PhoneEmp,@AddressEmp,@IdentityEmp,@IdProvince,@IdDistrict,@IdWard
,@IdReligion,@IdEthnic,@IdRankSalary,@IdSalaryBasic,@IdContract,@IdRole ,@Insurance,@IdDepartment,@IdPosition,@LevelEdu,@LanguageMaster,@DayOff,@NoteEmp,@Avarta)

GO
/****** Object:  StoredProcedure [dbo].[sp_InsertEmpPro]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_InsertEmpPro]
@idemp varchar(5),
@idpro varchar(5),
@datejoin date,
@content nvarchar(512),
@role  tinyint
as
Insert into tblEmpPro values (@idemp,@idpro,@datejoin,@content,@role)

GO
/****** Object:  StoredProcedure [dbo].[sp_insertEmpRe]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_insertEmpRe]
@IdEmpRe varchar(5) ,
@NameEmp nvarchar(128),
@BirthdayEmp date,
@Sex bit,
@StatusMarriage tinyint,
@PhoneEmp varchar(11),
@AddressEmp nvarchar(256),
@IdentityEmp varchar(12),
@IdProvince varchar(5) ,
@IdDistrict varchar(5)  ,
@IdWard varchar(5),
@IdReligion varchar(5),
@IdEthnic varchar(5),
@IdDepartment varchar(5),
@IdPosition varchar(5),
@IdContract varchar(5),
@LevelEdu int ,
@LanguageMaster nvarchar(128),
@NoteEmp nvarchar(256),
@Avarta varchar(512),
@StatusEmp bit
as
insert into tblEmployeeRe values (@IdEmpRe,@NameEmp,@BirthdayEmp,@Sex,@StatusMarriage,@PhoneEmp,@AddressEmp,@IdentityEmp,@IdProvince,@IdDistrict,@IdWard
,@IdReligion,@IdEthnic,@IdDepartment,@IdPosition,@IdContract,@LevelEdu,@LanguageMaster,@NoteEmp,@Avarta,@StatusEmp)

GO
/****** Object:  StoredProcedure [dbo].[sp_InsertPro]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[sp_InsertPro]
@id varchar(5),
@name nvarchar(256),
@content nvarchar(500),
@ds date,
@ddl date,
@val float
as
Insert into tblProject values (@id,@name,@content,@ds,@ddl,@val)

GO
/****** Object:  StoredProcedure [dbo].[sp_loadRank]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_loadRank]
@idsp int
as
SELECT        dbo.tblRankSalary.Id, dbo.tblRankSalary.NameRank, dbo.tblRankSalary.Coefficient
FROM            dbo.tblRankSalary INNER JOIN
                         dbo.tblSpecialized ON dbo.tblRankSalary.IdSpecialized = dbo.tblSpecialized.Id
where tblRankSalary.IdSpecialized=@idsp

GO
/****** Object:  StoredProcedure [dbo].[sp_loadRankSalarybasic]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_loadRankSalarybasic]
as
SELECT        Id, SalaryBasic
FROM            dbo.tblRankSalaryBasic

GO
/****** Object:  StoredProcedure [dbo].[sp_searchEmp]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[sp_searchEmp]


@name NVARCHAR(50),
@idDepar nvarchar(5)
as
select * from tblEmployee JOIN dbo.tblDeparment ON tblDeparment.IdDepartment = tblEmployee.IdDepartment
JOIN dbo.tblPosition ON tblPosition.IdPosition = tblEmployee.IdPosition
 where dbo.tblDeparment.IdDepartment = @idDepar AND NameEmp LIKE '%'+@name+'%'

GO
/****** Object:  StoredProcedure [dbo].[sp_searchEmpByidDepar]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_searchEmpByidDepar] 

@idDepar varchar(5)
as
select * from tblEmployee JOIN dbo.tblDeparment ON tblDeparment.IdDepartment = tblEmployee.IdDepartment
JOIN dbo.tblPosition ON tblPosition.IdPosition = tblEmployee.IdPosition where dbo.tblDeparment.IdDepartment = @idDepar




GO
/****** Object:  StoredProcedure [dbo].[sp_searchEmpReByidDepar]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_searchEmpReByidDepar] 
@idDepar varchar(5)
as
select * from tblEmployeeRe where IdDepartment = @idDepar

GO
/****** Object:  StoredProcedure [dbo].[sp_SearchEmpSalary]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_SearchEmpSalary]
@idep varchar(5),
@emp varchar(5)
as
SELECT        dbo.tblEmployee.IdEmp, dbo.tblEmployee.NameEmp, dbo.tblPosition.NamePosition, dbo.tblRankSalary.NameRank, dbo.tblRankSalary.Coefficient, dbo.tblSpecialized.NameSpecial, dbo.tblRankSalaryBasic.Id, 
                         dbo.tblRankSalaryBasic.SalaryBasic
FROM            dbo.tblEmployee INNER JOIN
                         dbo.tblRankSalary ON dbo.tblEmployee.IdRankSalary = dbo.tblRankSalary.Id INNER JOIN
                         dbo.tblRankSalaryBasic ON dbo.tblEmployee.IdSalaryBasic = dbo.tblRankSalaryBasic.Id INNER JOIN
                         dbo.tblPosition ON dbo.tblEmployee.IdPosition = dbo.tblPosition.IdPosition INNER JOIN
                         dbo.tblDeparment ON dbo.tblEmployee.IdDepartment = dbo.tblDeparment.IdDepartment INNER JOIN
                         dbo.tblSpecialized ON dbo.tblRankSalary.IdSpecialized = dbo.tblSpecialized.Id
where	tblEmployee.IdDepartment=@idep and tblEmployee.IdEmp like '%'+@emp+'%'

GO
/****** Object:  StoredProcedure [dbo].[sp_setRole]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_setRole]
@id varchar(5)
as
SELECT        dbo.tblEmployee.IdEmp,dbo.tblEmployee.Username, dbo.tblRole.Id, dbo.tblEmployee.Pass, dbo.tblEmployee.NameEmp
FROM            dbo.tblEmployee INNER JOIN
                         dbo.tblRole ON dbo.tblEmployee.IdRole = dbo.tblRole.Id
						 where tblEmployee.IdEmp =@id

GO
/****** Object:  StoredProcedure [dbo].[sp_Timekeeping]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_Timekeeping]
@id varchar(5),
@date date,
@stt bit,
@note nvarchar(128)
as
insert into tblTimekeeping values (@id,@date,@stt,@note)


GO
/****** Object:  StoredProcedure [dbo].[sp_updateEmpRe]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



create proc [dbo].[sp_updateEmpRe]
@NameEmp nvarchar(128),
@BirthdayEmp date,
@Sex bit,
@StatusMarriage tinyint,
@PhoneEmp varchar(11),
@AddressEmp nvarchar(256),
@IdentityEmp varchar(12),
@IdProvince varchar(5) ,
@IdDistrict varchar(5)  ,
@IdWard varchar(5),
@IdReligion varchar(5),
@IdEthnic varchar(5),
@IdDepartment varchar(5),
@IdPosition varchar(5),
@IdContract nvarchar(5),
@LevelEdu int ,
@LanguageMaster nvarchar(128),
@NoteEmp nvarchar(256),
@Avarta varchar(512),
@StatusEmp bit,
@IdEmpRe varchar(5) 
as
	update tblEmployeeRe  set
tblEmployeeRe.NameEmp = @NameEmp,
BirthdayEmp = @BirthdayEmp,
Sex = @Sex,
StatusMarriage=@StatusMarriage,
PhoneEmp=@PhoneEmp,
AddressEmp=@AddressEmp,
IdentityEmp=@IdentityEmp,
IdProvince=@IdProvince,
IdDistrict=@IdDistrict,
IdWard=@IdWard,
IdReligion=@IdReligion,
IdEthnic=@IdEthnic,
IdDepartment=@IdDepartment,
IdPosition=@IdPosition,
IdContract = @IdContract,
LevelEdu=@LevelEdu,
LanguageMaster=@LanguageMaster,
NoteEmp=@NoteEmp,
Avarta=@Avarta,
StatusEmp = @StatusEmp
where IdEmpRe = @IdEmpRe 

GO
/****** Object:  StoredProcedure [dbo].[sp_UpdatePro]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_UpdatePro]

@name nvarchar(256),
@content nvarchar(500),
@ds date,
@ddl date,
@val float,
@id varchar(5)
as
Update tblProject set tblProject.NamePro=@name,tblProject.ContentPro=@content,tblProject.DateSign=@ds,tblProject.DateDeadline=@ddl,tblProject.ValPro=@val where tblProject.Id = @id

GO
/****** Object:  StoredProcedure [dbo].[sp_updateRank]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_updateRank]
@id int,
@namerank nvarchar(50),
@idsp int,
@coef float
as
update tblRankSalary set IdSpecialized=@idsp,NameRank=@namerank,Coefficient=@coef where Id=@id

GO
/****** Object:  StoredProcedure [dbo].[sp_Wards]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_Wards]
@id varchar(5)
as
select * from tblWards inner join tblDistrict on tblDistrict.IdDistrict = tblWards.IdDistrict where tblWards.IdDistrict=@id
select * from tblDisciplineReward

GO
/****** Object:  StoredProcedure [dbo].[update_DREmp]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[update_DREmp]
@idEmp varchar(5),
@idDR varchar(5),
@DateDR date,
@Reson nvarchar(256),
@Content nvarchar(256)
as
update
tblDREmp set 
DateDR = @DateDR , Reson = @Reson,Content = @Content where IdEmp = @idEmp and Id = @idDR

GO
/****** Object:  StoredProcedure [dbo].[update_Employee]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[update_Employee]
@Username varchar(128),
@Pass varchar(128),
@NameEmp nvarchar(128),
@BirthdayEmp date,
@Sex bit,
@StatusMarriage tinyint,
@PhoneEmp varchar(11),
@AddressEmp nvarchar(256),
@IdentityEmp varchar(12),
@IdProvince varchar(5) ,
@IdDistrict varchar(5)  ,
@IdWard varchar(5),
@IdReligion varchar(5),
@IdEthnic varchar(5),
@IdRankSalary int ,
@IdSalaryBasic varchar(1),
@IdContract varchar(5),
@IdRole int,
@Insurance bit,
@IdDepartment varchar(5),
@IdPosition varchar(5),
@LevelEdu int ,
@LanguageMaster nvarchar(128),
@DayOff int,
@NoteEmp nvarchar(256),
@Avarta varchar(512),@StatusEmp BIT,
@IdEmp varchar(5) 

as
update tblEmployee
set
tblEmployee.Username =@Username ,
tblEmployee.Pass = @Pass,
tblEmployee.NameEmp=@NameEmp,
tblEmployee.BirthdayEmp=@BirthdayEmp,
tblEmployee.Sex= @Sex,
tblEmployee.StatusMarriage = @StatusMarriage,
tblEmployee.PhoneEmp =@PhoneEmp,
tblEmployee.AddressEmp=@AddressEmp,
tblEmployee.IdentityEmp=@IdentityEmp,
tblEmployee.IdProvince=@IdProvince,
tblEmployee.IdDistrict=@IdDistrict,
tblEmployee.IdWard=@IdWard,
tblEmployee.IdReligion=@IdReligion,
tblEmployee.IdEthnic=@IdEthnic,
tblEmployee.IdRankSalary=@IdRankSalary,
tblEmployee.IdSalaryBasic=@IdSalaryBasic,
tblEmployee.IdContract=@IdContract,
tblEmployee.IdRole =@IdRole, 
tblEmployee.Insurance=@Insurance,
tblEmployee.IdDepartment=@IdDepartment,
tblEmployee.IdPosition=@IdPosition,
tblEmployee.LevelEdu=@LevelEdu,
tblEmployee.LanguageMaster=@LanguageMaster,
tblEmployee.DayOff=@DayOff,
tblEmployee.NoteEmp = @NoteEmp,
tblEmployee.Avarta=@Avarta,
tblEmployee.statusEmp=@StatusEmp
where tblEmployee.IdEmp = @IdEmp
GO
/****** Object:  StoredProcedure [dbo].[updateContract]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateContract]

@DateSign date,
@DateExpied date,
@ContenContract ntext,
@StatusContract int,
@id varchar(5)
as
UPDATE [dbo].[tblContracts]
   SET
      [DateSign] = @DateSign
      ,[DateExpied] = @DateExpied
      ,[ContenContract] = @ContenContract
      ,[StatusContract] =@StatusContract
 WHERE  [Id] = @id

GO
/****** Object:  StoredProcedure [dbo].[updateEmpPro]    Script Date: 3/5/2020 12:27:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateEmpPro]
@datejoin date,
@content nvarchar(512),
@role  tinyint,
@idemp varchar(5),
@idpro varchar(5)
as
update tblEmpPro set tblEmpPro.dateJoin=@datejoin, tblEmpPro.Status = @content,tblEmpPro.Roles=@role where tblEmpPro.IdEmp=@idemp and tblEmpPro.IdPro=@idpro

GO
USE [master]
GO
ALTER DATABASE [ManagerHR] SET  READ_WRITE 
GO
