<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/list">
        <HTML>
            <HEAD>
                <TITLE>Reporte</TITLE>
            </HEAD>
            <BODY>
                <xsl:for-each select="object-array">
                    <P>
                        <xsl:value-of select="string"/>
                    </P>
                </xsl:for-each>
            </BODY>
        </HTML>
    </xsl:template>
</xsl:stylesheet> 