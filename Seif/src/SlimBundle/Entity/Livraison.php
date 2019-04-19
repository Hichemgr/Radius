<?php

namespace SlimBundle\Entity;

use SBC\NotificationsBundle\Model\BaseNotification;

/**
 * Livraison
 */
class Livraison 
{
    /**
     * @var float
     */
    private $montant;

    /**
     * @var integer
     */
    private $etat;

    /**
     * @var \DateTime
     */
    private $date;

    /**
     * @var string
     */
    private $adresse;

    /**
     * @var float
     */
    private $longitude;

    /**
     * @var float
     */
    private $latitude;

    /**
     * @var string
     */
    private $nomclient;

    /**
     * @var string
     */
    private $nomlivreur;

    /**
     * @var integer
     */
    private $idLivraison;

    /**
     * @var \AppBundle\Entity\Utilisateur
     */
    private $idUser;

    /**
     * @var \AppBundle\Entity\Commande
     */
    private $idcommande;


    /**
     * Set montant
     *
     * @param float $montant
     *
     * @return Livraison
     */
    public function setMontant($montant)
    {
        $this->montant = $montant;

        return $this;
    }

    /**
     * Get montant
     *
     * @return float
     */
    public function getMontant()
    {
        return $this->montant;
    }

    /**
     * Set etat
     *
     * @param integer $etat
     *
     * @return Livraison
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return integer
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * Set date
     *
     * @param \DateTime $date
     *
     * @return Livraison
     */
    public function setDate($date)
    {
        $this->date = $date;

        return $this;
    }

    /**
     * Get date
     *
     * @return \DateTime
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * Set adresse
     *
     * @param string $adresse
     *
     * @return Livraison
     */
    public function setAdresse($adresse)
    {
        $this->adresse = $adresse;

        return $this;
    }

    /**
     * Get adresse
     *
     * @return string
     */
    public function getAdresse()
    {
        return $this->adresse;
    }

    /**
     * Set longitude
     *
     * @param float $longitude
     *
     * @return Livraison
     */
    public function setLongitude($longitude)
    {
        $this->longitude = $longitude;

        return $this;
    }

    /**
     * Get longitude
     *
     * @return float
     */
    public function getLongitude()
    {
        return $this->longitude;
    }

    /**
     * Set latitude
     *
     * @param float $latitude
     *
     * @return Livraison
     */
    public function setLatitude($latitude)
    {
        $this->latitude = $latitude;

        return $this;
    }

    /**
     * Get latitude
     *
     * @return float
     */
    public function getLatitude()
    {
        return $this->latitude;
    }

    /**
     * Set nomclient
     *
     * @param string $nomclient
     *
     * @return Livraison
     */
    public function setNomclient($nomclient)
    {
        $this->nomclient = $nomclient;

        return $this;
    }

    /**
     * Get nomclient
     *
     * @return string
     */
    public function getNomclient()
    {
        return $this->nomclient;
    }

    /**
     * Set nomlivreur
     *
     * @param string $nomlivreur
     *
     * @return Livraison
     */
    public function setNomlivreur($nomlivreur)
    {
        $this->nomlivreur = $nomlivreur;

        return $this;
    }

    /**
     * Get nomlivreur
     *
     * @return string
     */
    public function getNomlivreur()
    {
        return $this->nomlivreur;
    }

    /**
     * Get idLivraison
     *
     * @return integer
     */
    public function getIdLivraison()
    {
        return $this->idLivraison;
    }

    /**
     * Set idUser
     *
     * @param \AppBundle\Entity\Utilisateur $idUser
     *
     * @return Livraison
     */
    public function setIdUser(\AppBundle\Entity\Utilisateur $idUser = null)
    {
        $this->idUser = $idUser;

        return $this;
    }

    /**
     * Get idUser
     *
     * @return \AppBundle\Entity\Utilisateur
     */
    public function getIdUser()
    {
        return $this->idUser;
    }

    /**
     * Set idcommande
     *
     * @param \AppBundle\Entity\Commande $idcommande
     *
     * @return Livraison
     */
    public function setIdcommande(\AppBundle\Entity\Commande $idcommande = null)
    {
        $this->idcommande = $idcommande;

        return $this;
    }

    /**
     * Get idcommande
     *
     * @return \AppBundle\Entity\Commande
     */
    public function getIdcommande()
    {
        return $this->idcommande;
    }
}

