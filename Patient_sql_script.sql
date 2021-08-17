CREATE DATABASE patient;

CREATE TABLE [dbo].[patient_details](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](100) NOT NULL,
	[middle_name] [varchar](100) NULL,
	[last_name] [varchar](100) NULL,
	[age] [int] NOT NULL,
	[gender] [varchar](20) NOT NULL,
	[blood_group][VARCHAR](10) NOT NULL,
	[contact_number] [bigint] NULL,
	[created_by] [varchar](70) NOT NULL,
	[created_on] [date] NOT NULL,
	[modified_by] [varchar](50) NOT NULL,
	[modified_on] [date] NOT NULL,
	[is_deleted] [tinyint] NOT NULL,
 CONSTRAINT [PK_patient] PRIMARY KEY(id),
  CONSTRAINT UC_Patient UNIQUE([first_name],[middle_name],[last_name]));