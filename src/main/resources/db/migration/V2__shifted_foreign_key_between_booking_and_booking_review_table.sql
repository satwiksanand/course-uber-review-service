-- 1. Drop existing constraints on booking.booking_review_id
alter table booking
    drop constraint FK_booking_booking_review;

alter table booking
    drop constraint UK_booking_booking_review;

-- 2. Drop the old column
alter table booking
    drop column booking_review_id;

-- 3. Add booking_id column to booking_review
alter table booking_review
    add column booking_id bigint;

-- 4. Add a UNIQUE constraint (1:1 relationship)
alter table booking_review
    add constraint UK_booking_review_booking
    unique (booking_id);

-- 5. Add the NEW foreign key: booking_review.booking_id -> booking.id
alter table booking_review
    add constraint FK_booking_review_booking
    foreign key (booking_id)
    references booking (id);
