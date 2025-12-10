create table booking (
    booking_review_id bigint,
    created_at datetime(6),
    driver_id bigint,
    end_time datetime(6),
    id bigint not null auto_increment,
    passenger_id bigint,
    start_time datetime(6),
    total_distance bigint,
    updated_at datetime(6),
    booking_status enum ('ARRIVED','ASSIGNING_DRIVER','CANCELLED','CONFIRMED','IN_RIDE'),
    primary key (id)
);

-- Hibernate
create table booking_review (
    rating double,
    created_at datetime(6),
    id bigint not null auto_increment,
    updated_at datetime(6),
    content varchar(255) not null,
    primary key (id)
);

-- Hibernate
create table driver (
    created_at datetime(6),
    id bigint not null auto_increment,
    updated_at datetime(6),
    license_number varchar(255),
    name varchar(255),
    primary key (id)
);

-- Hibernate
create table passenger (
    created_at datetime(6),
    id bigint not null auto_increment,
    updated_at datetime(6),
    name varchar(255),
    primary key (id)
);

-- Hibernate
create table passenger_review (
    passenger_rating double,
    id bigint not null,
    passenger_review varchar(255),
    primary key (id)
);

-- Unique Constraint for Booking Review
alter table booking
   add constraint UK_booking_booking_review
   unique (booking_review_id);

-- FK: Booking -> BookingReview
alter table booking
   add constraint FK_booking_booking_review
   foreign key (booking_review_id)
   references booking_review (id);

-- FK: Booking -> Driver
alter table booking
   add constraint FK_booking_driver
   foreign key (driver_id)
   references driver (id);

-- FK: Booking -> Passenger
alter table booking
   add constraint FK_booking_passenger
   foreign key (passenger_id)
   references passenger (id);

-- FK: PassengerReview -> BookingReview
alter table passenger_review
   add constraint FK_passenger_review_booking_review
   foreign key (id)
   references booking_review (id);
