<?php

namespace SlimBundle\Entity;

/**
 * Rendezvous
 */
class Rendezvous
{
    /**
     * @var string
     */
    private $sujet;

    /**
     * @var string
     */
    private $lieu;

    /**
     * @var \DateTime
     */
    private $daterendezvous;

    /**
     * @var integer
     */
    private $etat;

    /**
     * @var integer
     */
    private $idrendezvous;

    /**
     * @var \AppBundle\Entity\Utilisateur
     */
    private $idutilisateur;


    /**
     * Set sujet
     *
     * @param string $sujet
     *
     * @return Rendezvous
     */
    public function setSujet($sujet)
    {
        $this->sujet = $sujet;

        return $this;
    }

    /**
     * Get sujet
     *
     * @return string
     */
    public function getSujet()
    {
        return $this->sujet;
    }

    /**
     * Set lieu
     *
     * @param string $lieu
     *
     * @return Rendezvous
     */
    public function setLieu($lieu)
    {
        $this->lieu = $lieu;

        return $this;
    }

    /**
     * Get lieu
     *
     * @return string
     */
    public function getLieu()
    {
        return $this->lieu;
    }

    /**
     * Set daterendezvous
     *
     * @param \DateTime $daterendezvous
     *
     * @return Rendezvous
     */
    public function setDaterendezvous($daterendezvous)
    {
        $this->daterendezvous = $daterendezvous;

        return $this;
    }

    /**
     * Get daterendezvous
     *
     * @return \DateTime
     */
    public function getDaterendezvous()
    {
        return $this->daterendezvous;
    }

    /**
     * Set etat
     *
     * @param integer $etat
     *
     * @return Rendezvous
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
     * Get idrendezvous
     *
     * @return integer
     */
    public function getIdrendezvous()
    {
        return $this->idrendezvous;
    }

    /**
     * Set idutilisateur
     *
     * @param \AppBundle\Entity\Utilisateur $idutilisateur
     *
     * @return Rendezvous
     */
    public function setIdutilisateur(\AppBundle\Entity\Utilisateur $idutilisateur = null)
    {
        $this->idutilisateur = $idutilisateur;

        return $this;
    }

    /**
     * Get idutilisateur
     *
     * @return \AppBundle\Entity\Utilisateur
     */
    public function getIdutilisateur()
    {
        return $this->idutilisateur;
    }
}

