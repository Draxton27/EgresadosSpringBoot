-- setup.sql

-- Create the database
CREATE DATABASE EgresadoDb;
GO

-- Use the newly created database
USE EgresadoDb;
GO

-- Create login
CREATE LOGIN EgresadosUAMLogin WITH PASSWORD = 'Password123#';
GO

-- Create user for the database
CREATE USER EgresadosUAMUser FOR LOGIN EgresadosUAMLogin;
GO

-- Grant necessary permissions
ALTER ROLE db_owner ADD MEMBER EgresadosUAMUser;
GO
