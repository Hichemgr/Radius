<?php

namespace SlimBundle\Entity;

/**
 * Vote
 */
class Vote
{
    /**
     * @var integer
     */
    private $note;

    /**
     * @var string
     */
    private $nomv;

    /**
     * @var integer
     */
    private $idvote;

    /**
     * @var \AppBundle\Entity\Utilisateur
     */
    private $idutilisateur;


    /**
     * Set note
     *
     * @param integer $note
     *
     * @return Vote
     */
    public function setNote($note)
    {
        $this->note = $note;

        return $this;
    }

    /**
     * Get note
     *
     * @return integer
     */
    public function getNote()
    {
        return $this->note;
    }

    /**
     * Set nomv
     *
     * @param string $nomv
     *
     * @return Vote
     */
    public function setNomv($nomv)
    {
        $this->nomv = $nomv;

        return $this;
    }

    /**
     * Get nomv
     *
     * @return string
     */
    public function getNomv()
    {
        return $this->nomv;
    }

    /**
     * Get idvote
     *
     * @return integer
     */
    public function getIdvote()
    {
        return $this->idvote;
    }

    /**
     * Set idutilisateur
     *
     * @param \AppBundle\Entity\Utilisateur $idutilisateur
     *
     * @return Vote
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

