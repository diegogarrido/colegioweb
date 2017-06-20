<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/list">
        <HTML>
            <HEAD>
                <TITLE>Reporte</TITLE>
                <link rel="stylesheet" href="/colegioWEB/css/pagina.css" media="screen"></link>
                <link rel="stylesheet" href="/colegioWEB/css/botones.css" media="screen"></link>
            </HEAD>
            <BODY>
                <div class="container" style="height: 500px;">
                <xsl:for-each select="object-array">
                    <xsl:choose>
                        <xsl:when test='contains(string,"&lt;") and contains(string,"&gt;")'>
                            <xsl:value-of select="string" disable-output-escaping="yes"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <P>
                                <xsl:value-of select="string"/>
                            </P>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:for-each>
                </div>
                <p>
                    <button type="button" class="btn btn-4" style="margin: auto" onclick="window.location = '/colegioWEB/index.jsp';"> 
                        Inicio
                    </button>
                </p>
            </BODY>
        </HTML>
    </xsl:template>
</xsl:stylesheet> 