<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="java/object">
        <HTML>
            <HEAD>
                <TITLE>Documentos del curso</TITLE>
            </HEAD>
            <BODY>
                <xsl:for-each select="void[1]/void">
                <P>
                    Alumno: <xsl:value-of select="object/void[@property='nombre']/string"/>
                    <P>Notas:</P>
                    <xsl:for-each select="object/void[@property='notas']">
                        <P>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[1]/object/void/string"/></P>
                        <P>
                            <xsl:value-of select="substring-before(void[1]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[2]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[3]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[4]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[5]/string,',')"/>
                        </P>
                        <P>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[2]/object/void/string"/></P>
                        <P>
                            <xsl:value-of select="substring-before(void[6]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[7]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[8]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[9]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[10]/string,',')"/>
                        </P>
                        <P>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[3]/object/void/string"/></P>
                        <P>
                            <xsl:value-of select="substring-before(void[11]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[12]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[13]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[14]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[15]/string,',')"/>
                        </P>
                        <P>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[4]/object/void/string"/></P>
                        <P>
                            <xsl:value-of select="substring-before(void[16]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[17]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[18]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[19]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[20]/string,',')"/>
                        </P>
                        <P>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[5]/object/void/string"/></P>
                        <P>
                            <xsl:value-of select="substring-before(void[21]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[22]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[23]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[24]/string,',')"/>
                        </P>
                        <P>
                            <xsl:value-of select="substring-before(void[25]/string,',')"/>
                        </P>
                    </xsl:for-each>
                    <P>Anotaciones: </P>
                    <P>Tipo , Razón </P>
                        <xsl:for-each select="object/void[@property='anotaciones']/void">
                            <P>
                                <xsl:value-of select="string"/>
                            </P>
                        </xsl:for-each>
                </P>
            </xsl:for-each>
                
                <xsl:for-each select="void[2]/void/object">
                    <P>Asignatura: <xsl:value-of select="void/string"/></P>
                    <P>Profesor:<xsl:value-of select="void[3]/string"/></P>
                    <P>Nombre Actividad , Fecha actividad</P>
                    <xsl:for-each select="void/void">
                        <P>
                            <xsl:value-of select="substring-before(string,',')" />
                            <xsl:value-of select="substring-after(string,'true')" />
                            <xsl:value-of select="substring-after(string,'false')" />
                        </P>
                    </xsl:for-each>
                    <BR></BR>
                </xsl:for-each>
            </BODY>
        </HTML>
    </xsl:template>
</xsl:stylesheet> 