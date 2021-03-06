<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ms="urn:schemas-microsoft-com:xslt" xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns="urn:schemas-microsoft-com:office:spreadsheet" version="1.0">
    <xsl:template match="/list">
        <Row>
            <xsl:for-each select="object-array">
                <xsl:choose>
                    <xsl:when test='not(contains(string,"&lt;") and contains(string,"&gt;"))'>
                        <Row>
                            <xsl:value-of select="string"/>
                        </Row>
                    </xsl:when>
                </xsl:choose>
            </xsl:for-each>   
        </Row>
    </xsl:template>
</xsl:stylesheet>