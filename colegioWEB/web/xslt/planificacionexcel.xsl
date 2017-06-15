<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ms="urn:schemas-microsoft-com:xslt" xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns="urn:schemas-microsoft-com:office:spreadsheet" version="1.0">
    <xsl:template match="java/object">
        <Row>
            <xsl:for-each select="void[1]/void">
                <Row>
                    <Row>Alumno: <xsl:value-of select="object/void[@property='nombre']/string"/></Row>
                    <Row>Notas:</Row>
                    <xsl:for-each select="object/void[@property='notas']">
                        <Row>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[1]/object/void/string"/></Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[1]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[2]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[3]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[4]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[5]/string,',')"/>
                        </Row>
                        <Row>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[2]/object/void/string"/></Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[6]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[7]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[8]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[9]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[10]/string,',')"/>
                        </Row>
                        <Row>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[3]/object/void/string"/></Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[11]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[12]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[13]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[14]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[15]/string,',')"/>
                        </Row>
                        <Row>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[4]/object/void/string"/></Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[16]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[17]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[18]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[19]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[20]/string,',')"/>
                        </Row>
                        <Row>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[5]/object/void/string"/></Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[21]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[22]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[23]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[24]/string,',')"/>
                        </Row>
                        <Row>
                            <xsl:value-of select="substring-before(void[25]/string,',')"/>
                        </Row>
                    </xsl:for-each>
                    <Row>Anotaciones: </Row>
                    <Row>Tipo , Razón </Row>
                    <xsl:for-each select="object/void[@property='anotaciones']/void">
                        <Row>
                            <xsl:value-of select="string"/>
                        </Row>
                    </xsl:for-each>
                </Row>
            </xsl:for-each>
            <xsl:for-each select="void[2]/void/object">
                <Row>
                    <Row>Asignatura: <xsl:value-of select="void/string"/></Row>
                    <Row>Profesor:<xsl:value-of select="void[3]/string"/></Row>
                    <Row>Nombre Actividad , Fecha actividad</Row>
                    <xsl:for-each select="void/void">
                        <Row>
                            <xsl:value-of select="substring-before(string,',')" />
                            <xsl:value-of select="substring-after(string,'true')" />
                            <xsl:value-of select="substring-after(string,'false')" />
                        </Row>
                    </xsl:for-each>
                </Row>
            </xsl:for-each>
        </Row>
    </xsl:template>
</xsl:stylesheet>