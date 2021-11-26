package com.javeriana.ares.sds.resolutions.crosscutting.constants;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Constants {

    private Constants() {
    }

    public static final String TOPIC_NAME = "tramites";

    public static final SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("d 'del mes de' MMMM 'del año' yyyy",
            new Locale("es", "CO"));
    public static final String RESOLUTION_TITLE = "Resolución No {id} del día {date}";
    public static final String RESOLUTION_TITLE_2 = "Secretaría Distrital de Salud de Bogotá D.C";
    public static final String RESOLUTION_PARAGRAPH_1 = "Por la cual se autoriza el ejercicio de una profesión/ocupación en el Territorio Nacional. " +
            "LA SUBDIRECCIÓN INSPECCIÓN, VIGILANCIA Y CONTROL DE SERVICIOS DE SALUD";
    public static final String RESOLUTION_PARAGRAPH_2 = "En uso de sus facultades legales y en especial las conferidas por el Decreto 780 de 2016, " +
            "Ley 1164 de 2007 y Resolución 3030 de 2014 del Ministerio de Salud y Protección Social y, ";
    public static final String RESOLUTION_TITLE_3 = "CONSIDERANDO";
    public static final String RESOLUTION_PARAGRAPH_3 = "Que el(la) señor(a) {fullName}, solicitó ante esta Secretaría la autorización del ejercicio " +
            "de su profesión/ocupación {job} otorgado por , el día {titleDate}, con el acta {actNumber}, registrado en el libro {bookNumber}, " +
            "Folio {folioNumber}, año {yearTitle}. Que estudiada la documentación presentada por el solicitante esta cumple con los requisitos " +
            "establecidos en las normas legales vigentes; En virtud de lo expuesto este Despacho, ";
    public static final String RESOLUTION_TITLE_4 = "RESUELVE:";
    public static final String STATUS_APPROVE = "APROBADO";
    public static final String STATUS_DENY = "DESAPROBADO";
    public static final String STATUS_GENERATED = "-GENERADO";
    public static final String STATUS_APPROVE_MESSAGE = "AUTORIZAR";
    public static final String STATUS_DENY_MESSAGE = "NEGAR AUTORIZACIÓN";
    public static final String RESOLUTION_ARTICLE_1 = "ARTICULO PRIMERO: {statusMessage} a {fullName}, para ejercer la profesión/ocupación de " +
            "{job} en el Territorio Nacional. ";

    public static final String ARTICLE_2 = "ARTICULO SEGUNDO";
    public static final String ARTICLE_3 = "ARTICULO TERCERO";
    public static final String RESOLUTION_ARTICLE_2 = ARTICLE_2 + ": {fullName}, quedará inscrito en el Registro Único Nacional del Talento Humano " +
            "en Salud (RETHUS) dentro de los primeros (5) cinco días hábiles del mes inmediatamente siguiente al de expedición de este Acto Administrativo.";
    public static final String RESOLUTION_ARTICLE_3 = "{article}: Notifíquese electrónicamente el contenido de la presente Resolución a {fullName}, " +
            "o a quien haga sus veces, haciéndole saber que, contra la misma sólo procede el recurso de reposición ante esta Dirección, el cual deberá " +
            "interponerse dentro de los diez (10) días siguientes a la notificación electrónica, por medio de la plataforma virtual mediante la cual se " +
            "llevó a cabo el trámite inicial o por escrito. ";

    public static final String RESOLUTION_PARAGRAPH_4 = "NOTIFIQUESE, Y CÚMPLASE Dada en Bogotá, D.C. a los {date}";
    public static final String SIGN = "G.A";
    public static final String SIGN_NAME = "GRUPO ARES";
}
