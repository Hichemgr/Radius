<?php

namespace SlimBundle\Entity;

/**
 * Promotion
 */
class Promotion
{
    /**
     * @var string
     */
    private $nom;

    /**
     * @var \DateTime
     */
    private $datedebut;

    /**
     * @var \DateTime
     */
    private $datefin;

    /**
     * @var integer
     */
    private $pourcentage;

    /**
     * @var string
     */
    private $nomproduit;

    /**
     * @var float
     */
    private $nouveauprix;

    /**
     * @var integer
     */
    private $idpromotion;


    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return Promotion
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set datedebut
     *
     * @param \DateTime $datedebut
     *
     * @return Promotion
     */
    public function setDatedebut($datedebut)
    {
        $this->datedebut = $datedebut;

        return $this;
    }

    /**
     * Get datedebut
     *
     * @return \DateTime
     */
    public function getDatedebut()
    {
        return $this->datedebut;
    }

    /**
     * Set datefin
     *
     * @param \DateTime $datefin
     *
     * @return Promotion
     */
    public function setDatefin($datefin)
    {
        $this->datefin = $datefin;

        return $this;
    }

    /**
     * Get datefin
     *
     * @return \DateTime
     */
    public function getDatefin()
    {
        return $this->datefin;
    }

    /**
     * Set pourcentage
     *
     * @param integer $pourcentage
     *
     * @return Promotion
     */
    public function setPourcentage($pourcentage)
    {
        $this->pourcentage = $pourcentage;

        return $this;
    }

    /**
     * Get pourcentage
     *
     * @return integer
     */
    public function getPourcentage()
    {
        return $this->pourcentage;
    }

    /**
     * Set nomproduit
     *
     * @param string $nomproduit
     *
     * @return Promotion
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
     * Set nouveauprix
     *
     * @param float $nouveauprix
     *
     * @return Promotion
     */
    public function setNouveauprix($nouveauprix)
    {
        $this->nouveauprix = $nouveauprix;

        return $this;
    }

    /**
     * Get nouveauprix
     *
     * @return float
     */
    public function getNouveauprix()
    {
        return $this->nouveauprix;
    }

    /**
     * Get idpromotion
     *
     * @return integer
     */
    public function getIdpromotion()
    {
        return $this->idpromotion;
    }
    public function __toString(){
        // to show the name of the Category in the select
        return $this->nouveauprix;
        // to show the id of the Category in the select
        // return $this->id;
    }
}

