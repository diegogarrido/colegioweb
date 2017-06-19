<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template name="temp" match= "/list">
        <w:wordDocument xmlns:w="http://schemas.microsoft.com/office/word/2003/2/wordml">
            <xsl:processing-instruction name="mso-application">progid="Word.Document"</xsl:processing-instruction>
            <xsl:for-each select="object-array">
                <w:r>
                    <xsl:value-of select="string"/>
                </w:r>
            </xsl:for-each>
        </w:wordDocument>
    </xsl:template>
</xsl:stylesheet>