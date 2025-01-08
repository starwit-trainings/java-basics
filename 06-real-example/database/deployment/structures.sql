CREATE SEQUENCE IF NOT EXISTS "club_id_seq";

CREATE TABLE public.clubs (
    id integer NOT NULL DEFAULT nextval('club_id_seq'),
    name character varying(255) NOT NULL,
    league_id integer,
    CONSTRAINT "club_pkey" PRIMARY KEY ("id")
);


CREATE SEQUENCE IF NOT EXISTS "game_id_seq";
CREATE TABLE public.game (
    id integer NOT NULL DEFAULT nextval('game_id_seq'),
    matchday integer,
    date date,
    "time" time without time zone,
    home_club integer NOT NULL,
    guest_club integer NOT NULL,
    goals_home integer,
    goals_guest integer,
    CONSTRAINT "game_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "league_id_seq";
CREATE TABLE public.league (
    id integer NOT NULL DEFAULT nextval('league_id_seq'),
    association character varying(255) NOT NULL,
    first_match date NOT NULL,
    champion integer,
    record_player character varying(255) DEFAULT NULL::character varying,
    games_recordplayer integer,
    CONSTRAINT "league_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "player_id_seq";
CREATE TABLE public.player (
    id integer NOT NULL DEFAULT nextval('player_id_seq'),
    club_id integer NOT NULL,
    trikot_no integer,
    name character varying(255) NOT NULL,
    country character varying(255) DEFAULT NULL::character varying,
    games integer,
    goals integer,
    assists integer,
    CONSTRAINT "player_pkey" PRIMARY KEY ("id")
);

ALTER TABLE ONLY public.clubs
    ADD CONSTRAINT club_league_fk FOREIGN KEY (league_id) REFERENCES public.league(id) ON DELETE SET NULL;

ALTER TABLE ONLY public.game
    ADD CONSTRAINT game_club_fk1 FOREIGN KEY (home_club) REFERENCES public.clubs(id);

ALTER TABLE ONLY public.game
    ADD CONSTRAINT game_club_fk2 FOREIGN KEY (guest_club) REFERENCES public.clubs(id);

ALTER TABLE ONLY public.player
    ADD CONSTRAINT player_club_fk FOREIGN KEY (club_id) REFERENCES public.clubs(id);


