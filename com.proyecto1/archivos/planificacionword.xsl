<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template name="temp" match= "java/object">
        <w:wordDocument xmlns:w="http://schemas.microsoft.com/office/word/2003/2/wordml">
            <xsl:processing-instruction name="mso-application">progid="Word.Document"</xsl:processing-instruction>
            <xsl:for-each select="void[1]/void">
                <w:r>
                    Alumno: <xsl:value-of select="object/void[@property='nombre']/string"/>
                    <w:r>Notas:</w:r>
                    <xsl:for-each select="object/void[@property='notas']">
                        <w:r>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[1]/object/void/string"/></w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[1]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[2]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[3]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[4]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[5]/string,',')"/>
                        </w:r>
                        <w:r>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[2]/object/void/string"/></w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[6]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[7]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[8]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[9]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[10]/string,',')"/>
                        </w:r>
                        <w:r>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[3]/object/void/string"/></w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[11]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[12]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[13]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[14]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[15]/string,',')"/>
                        </w:r>
                        <w:r>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[4]/object/void/string"/></w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[16]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[17]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[18]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[19]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[20]/string,',')"/>
                        </w:r>
                        <w:r>Asignatura: <xsl:value-of select="ancestor::java/object/void[2]/void[5]/object/void/string"/></w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[21]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[22]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[23]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[24]/string,',')"/>
                        </w:r>
                        <w:r>
                            <xsl:value-of select="substring-before(void[25]/string,',')"/>
                        </w:r>
                    </xsl:for-each>
                    <w:r>Anotaciones: </w:r>
                    <w:r>Tipo , Razón </w:r>
                        <xsl:for-each select="object/void[@property='anotaciones']/void">
                            <wr>
                                <xsl:value-of select="string"/>
                            </wr>
                        </xsl:for-each>
                </w:r>
            </xsl:for-each>

            <xsl:for-each select="void[2]/void/object">
                <w:r>
                    Asignatura: <xsl:value-of select="void/string"/>
                    <w:r>Profesor: <xsl:value-of select="void[3]/string"/></w:r>
                    <w:r>Nombre Actividad , Fecha actividad</w:r>
                    <xsl:for-each select="void/void">
                        <w:r>
                            <xsl:value-of select="substring-before(string,',')" />
                            <xsl:value-of select="substring-after(string,'true')" />
                            <xsl:value-of select="substring-after(string,'false')" />
                        </w:r>
                    </xsl:for-each>
                </w:r>
            </xsl:for-each>
        </w:wordDocument>
    </xsl:template>
</xsl:stylesheet>