
CREATE SEQUENCE public.adresse_id_seq;

CREATE TABLE public.adresse (
                id INTEGER NOT NULL DEFAULT nextval('public.adresse_id_seq'),
                numero_voie INTEGER NOT NULL,
                nom_voie VARCHAR(150) NOT NULL,
                ville VARCHAR(50) NOT NULL,
                code_postale INTEGER NOT NULL,
                pays VARCHAR(50) NOT NULL,
                CONSTRAINT adresse_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.adresse_id_seq OWNED BY public.adresse.id;

CREATE TABLE public.utilisateur (
                id INTEGER NOT NULL,
                pseudo VARCHAR(100) NOT NULL,
                civilite CHAR(1) NOT NULL,
                nom VARCHAR(100) NOT NULL,
                prenom VARCHAR(100) NOT NULL,
                telephone VARCHAR(30),
                email_perso VARCHAR(40) NOT NULL,
                email_pro VARCHAR(40),
                domaine VARCHAR(60),
                id_adresse INTEGER,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id)
);


CREATE TABLE public.sequence (
                id INTEGER NOT NULL,
                sequence VARCHAR(10000) NOT NULL,
                type CHAR(1) NOT NULL,
                nom VARCHAR(100) NOT NULL,
                id_user INTEGER,
                CONSTRAINT sequence_pk PRIMARY KEY (id)
);


ALTER TABLE public.utilisateur ADD CONSTRAINT adresse_utilisateur_fk
FOREIGN KEY (id_adresse)
REFERENCES public.adresse (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.sequence ADD CONSTRAINT user_sequence_fk
FOREIGN KEY (id_user)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
