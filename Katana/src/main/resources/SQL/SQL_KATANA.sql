CREATE TABLE "Aluno"(
    "id" INTEGER NOT NULL,
    "id_objetivo" TEXT NOT NULL,
    "id_grade" INTEGER NOT NULL
);
ALTER TABLE
    "Aluno" ADD PRIMARY KEY("id");
CREATE TABLE "Objetivos"(
    "id" INTEGER NOT NULL,
    "Projetos" TEXT NOT NULL,
    "Disciplinas" TEXT NOT NULL
);
ALTER TABLE
    "Objetivos" ADD PRIMARY KEY("id");
CREATE TABLE "Grade"(
    "id" INTEGER NOT NULL,
    "id_rotina" INTEGER NOT NULL
);
ALTER TABLE
    "Grade" ADD PRIMARY KEY("id");
CREATE TABLE "Rotina"(
    "id" INTEGER NOT NULL,
    "id_imprevistos" TEXT NOT NULL,
    "Habitos" TEXT NOT NULL
);
ALTER TABLE
    "Rotina" ADD PRIMARY KEY("id");
CREATE TABLE "Imprevistos"(
    "id" INTEGER NOT NULL,
    "Motivos" TEXT NOT NULL,
    "Historico" TEXT NOT NULL,
    "Consequencias" TEXT NOT NULL
);
ALTER TABLE
    "Imprevistos" ADD PRIMARY KEY("id");
CREATE TABLE "Grade_Compromisso"(
    "id_grade" INTEGER NOT NULL,
    "id_compromisso" INTEGER NOT NULL
);
CREATE TABLE "Compromisso"(
    "id" INTEGER NOT NULL,
    "Nome" CHAR(255) NOT NULL,
    "Tipo" TEXT NOT NULL
);
ALTER TABLE
    "Compromisso" ADD PRIMARY KEY("id");
ALTER TABLE
    "Grade_Compromisso" ADD CONSTRAINT "grade_compromisso_id_grade_foreign" FOREIGN KEY("id_grade") REFERENCES "Grade"("id");
ALTER TABLE
    "Aluno" ADD CONSTRAINT "aluno_id_grade_foreign" FOREIGN KEY("id_grade") REFERENCES "Grade"("id");
ALTER TABLE
    "Rotina" ADD CONSTRAINT "rotina_id_imprevistos_foreign" FOREIGN KEY("id_imprevistos") REFERENCES "Imprevistos"("id");
ALTER TABLE
    "Grade" ADD CONSTRAINT "grade_id_rotina_foreign" FOREIGN KEY("id_rotina") REFERENCES "Rotina"("id");
ALTER TABLE
    "Grade_Compromisso" ADD CONSTRAINT "grade_compromisso_id_compromisso_foreign" FOREIGN KEY("id_compromisso") REFERENCES "Compromisso"("id");