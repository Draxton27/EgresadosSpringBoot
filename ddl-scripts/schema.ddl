
    create table administrador (
        id varchar(32) not null,
        contrasenia varchar(255),
        nombre_admin varchar(255),
        primary key (id)
    );

    create table egresado (
        aprobado bit,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255),
        etnia varchar(255),
        log_in_email varchar(255),
        password varchar(255),
        posicion_actual varchar(255),
        primer_apellido varchar(255),
        primer_nombre varchar(255),
        segundo_apellido varchar(255),
        segundo_nombre varchar(255),
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255),
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255) not null,
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255) not null,
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255),
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255),
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255),
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255),
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255),
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255),
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;

    create table administrador (
        id varchar(32) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table egresado (
        aprobado bit not null,
        fecha_graduacion date,
        fecha_inicio date,
        fecha_nacimiento date not null,
        fecha_terminacion date,
        id varchar(32) not null,
        cif varchar(255),
        etnia varchar(255),
        log_in_email varchar(255) not null,
        password varchar(255),
        posicion_actual varchar(255),
        primer_apellido varchar(255) not null,
        primer_nombre varchar(255) not null,
        segundo_apellido varchar(255) not null,
        segundo_nombre varchar(255) not null,
        primary key (id)
    );

    create table egresado_carreras (
        egresado_id varchar(32) not null,
        carrera varchar(255)
    );

    create table egresado_contactos (
        egresado_id varchar(32) not null,
        numero varchar(255)
    );

    create table egresado_correos (
        egresado_id varchar(32) not null,
        correo varchar(255)
    );

    create table egresado_trabajos (
        fecha_inicio date,
        fecha_terminacion date,
        egresado_id varchar(32) not null,
        posicion_actual varchar(255)
    );

    create table encuestas (
        id varchar(32) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table form_answers_collected_from (
        form_id varchar(32) not null,
        answers_collected_from varchar(255)
    );

    create table form_questions (
        type smallint check (type between 0 and 1),
        form_id varchar(32) not null,
        answers varbinary(255),
        possible_answers varbinary(255),
        question varchar(255)
    );

    alter table egresado_carreras 
       add constraint FK273l7phvsb118m5jtn1kjtlfi 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_contactos 
       add constraint FKjtqpqvrkg1lpes3mnpfkf6t8y 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_correos 
       add constraint FKs9imxw8sbtuue9r8aef59urv9 
       foreign key (egresado_id) 
       references egresado;

    alter table egresado_trabajos 
       add constraint FK57dxhjwi768xb70mcetjs0tm8 
       foreign key (egresado_id) 
       references egresado;

    alter table form_answers_collected_from 
       add constraint FKdopt31reo2ix5tsrsclerrtt9 
       foreign key (form_id) 
       references encuestas;

    alter table form_questions 
       add constraint FKg6f00x08a8il2fj9o4frq8vub 
       foreign key (form_id) 
       references encuestas;
