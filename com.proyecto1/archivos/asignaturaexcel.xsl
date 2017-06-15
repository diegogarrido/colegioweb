<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ms="urn:schemas-microsoft-com:xslt" xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns="urn:schemas-microsoft-com:office:spreadsheet" version="1.0">
    <xsl:template match="java/object">
        <Row>
            <xsl:for-each select="void">
                <Row>
                    <xsl:value-of select="string"/>
                </Row>
            </xsl:for-each>   
        </Row>
    </xsl:template>
</xsl:stylesheet>