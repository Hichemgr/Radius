<?php

namespace SlimBundle\Entity;

/**
 * Pub
 */
class Pub
{
    /**
     * @var string
     */
    private $nompublicite;

    /**
     * @var \DateTime
     */
    private $datepub;

    /**
     * @var string
     */
    private $nomproduit;

    /**
     * @var integer
     */
    private $idpublicite;


    /**
     * Set nompublicite
     *
     * @param string $nompublicite
     *
     * @return Pub
     */
    public function setNompublicite($nompublicite)
    {
        $this->nompublicite = $nompublicite;

        return $this;
    }

    /**
     * Get nompublicite
     *
     * @return string
     */
    public function getNompublicite()
    {
        return $this->nompublicite;
    }

    /**
     * Set datepub
     *
     * @param \DateTime $datepub
     *
     * @return Pub
     */
    public function setDatepub($datepub)
    {
        $this->datepub = $datepub;

        return $this;
    }

    /**
     * Get datepub
     *
     * @return \DateTime
     */
    public function getDatepub()
    {
        return $this->datepub;
    }

    /**
     * Set nomproduit
     *
     * @param string $nomproduit
     *
     * @return Pub
     */
    public function setNomproduit($nomproduit)
    {
        $this->nomproduit = $nomproduit;

        return $this;
    }

    /**
     * Get nomproduit
     *
     * @return string
     */
    public function getNomproduit()
    {
        return $this->nomproduit;
    }

    /**
     * Get idpublicite
     *
     * @return integer
     */
    public function getIdpublicite()
    {
        return $this->idpublicite;
    }
}

