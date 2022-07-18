# CHANGELOG
============

v.1.0.0
=======
- New User, UserRepository, UserController, and UserService.
- New basic database data with 4 users.
- New application configuration file.
- Added the information about the project.

v.1.1.0
=======
# new features
- New UserException
- New UserDto (Validators, @JsonProperty, @JsonAlias)
- New UserMapper (mapstruck)
# changes from v.1.0.0
- Changed pom.xml (new dependencies -validator, mapstruck-, new plugins, and version)
- Changed UserController (added new endpoints, added DtoPattern)
- Changed User (log id  to String UUID)
- Changed UserRepository (changed Long to String)
- Changed UserService and UserServiceImpl (modified Long to UUID)
- Changed data.sql (new statement create table if not exist)